package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.dto.params.index.StartLabParamsDto;
import com.jishu5.ctfcommunityserver.dto.params.index.SubmitFlagParamsDto;
import com.jishu5.ctfcommunityserver.entity.*;
import com.jishu5.ctfcommunityserver.mapper.*;
import com.jishu5.ctfcommunityserver.service.SafeLabsRecordService;
import com.jishu5.ctfcommunityserver.service.SafeLabsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
@Service
public class SafeLabsServiceImpl extends ServiceImpl<SafeLabsMapper, SafeLabs> implements SafeLabsService {


    @Autowired
    private SafeLabsRecordService safeLabsRecordService;

    @Autowired
    private SSHBackUtil sshBackUtil;

    @Autowired
    private SafeLabsMapper safeLabsMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SafeDockerMapper safeDockerMapper;

    @Autowired
    private SafeDockerUserMapper safeDockerUserMapper;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private CoinRecordMapper coinRecordMapper;

    @Value("${ctf.nginx-address}")
    private String nginxAddress;

    @Override
    @Transactional
    public R startLab(StartLabParamsDto startLabParamsDto){
      try {
          Map<String, Object> resultMap = new HashMap<>();
          Map<String, Object> map = new HashMap<>();
          // 统一过期时间，分钟为单位
          Integer expireTime = 30;
          LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
          // 获取靶场数据
          SafeLabs safeLabs = safeLabsMapper.selectOne(new QueryWrapper<SafeLabs>().eq("id", startLabParamsDto.getLabId()));

          // 判断靶场是否存在
          SafeDockerUser safeDockerUser = safeDockerUserMapper.selectOne(new QueryWrapper<SafeDockerUser>().eq("user_id", loginUser.getUser().getId()).eq("lab_id",startLabParamsDto.getLabId()));
          System.out.println(safeDockerUser);
          if(safeDockerUser != null && safeDockerUser.getIsExist() == 1){
              return R.error("靶场已存在，等等待过期后重新创建...");
          }
          // 扣除用户金币
          User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", loginUser.getUser().getId()));
          user.setCoin(user.getCoin() - safeLabs.getNeedCoin());
          userMapper.updateById(user);

          // 增加金币用途记录
          CoinRecord coinRecord = new CoinRecord();
          coinRecord.setRemark("启动环境");
          coinRecord.setAmount(-safeLabs.getNeedCoin());
          coinRecord.setUserId(loginUser.getUser().getId());
          coinRecord.setCreateTime(new Date());
          coinRecord.setCount(user.getCoin());
          coinRecordMapper.insert(coinRecord);


          // 获取靶场创建代码
          SafeDocker safeDocker = safeDockerMapper.selectOne(new QueryWrapper<SafeDocker>().eq("id",safeLabs.getDockerId()));
          String dockerShell = safeDocker.getCreateShell();
          String nginxShell = safeDocker.getNginxShell();
          String introText = safeDocker.getIntroText();
          // 靶场映射端口
          String port = String.valueOf(new java.util.Random().nextInt(65535-10000)+10000);
          // 靶场唯一名
          String uuid = StringUtil.getUUID();
          dockerShell = dockerShell.replace("{{name}}",uuid).replace("{{port}}",port);
          introText = introText.replace("{{name}}",uuid);
          nginxShell = nginxShell.replace("{{name}}",uuid).replace("{{port}}",port).replace("{{nginx}}",nginxAddress);

          // 发送容器创建代码，接收返回的容器id号（container id）
          String containerId = sshBackUtil.sendCommand(dockerShell);
          if(containerId.equals("获取失败")){
              throw new RuntimeException("容器创建失败");
          }

          // 添加nginx域名映射
          // 发送nginx映射代码
          String nginxStatus = sshBackUtil.sendCommand(nginxShell);
          if(nginxStatus.equals("获取失败")){
              throw new RuntimeException("域名映射失败");
          }
          String nginxReloadStatus = sshBackUtil.sendCommand("systemctl reload nginx");
          if(nginxReloadStatus.equals("获取失败")){
              throw new RuntimeException("nginx重启失败");
          }

          // 设置redis到期时间，监听服务到期
          redisCache.setCacheObject("codetip:safe:labs:"+uuid,"true",expireTime, TimeUnit.MINUTES);
          // 判断用户是否曾经创建过该靶场，否则进行添加/更新
          if(safeDockerUser != null){
              map.put("isSuccess", safeDockerUser.getIsSuccess());
              safeDockerUser.setContainerId(containerId);
              safeDockerUser.setCreateTime(new Date());
              safeDockerUser.setPort(port);
              safeDockerUser.setIntro(introText);
              safeDockerUser.setDockerName(uuid);
              safeDockerUser.setIsExist(1);
              // 设置过期时间
              safeDockerUser.setExpTime(DateUtil.getAfterDate(new Date(),0,0,0,0,expireTime,0));
              safeDockerUserMapper.updateById(safeDockerUser);
          }else{
              map.put("isSuccess", 0);
              // 否则进行添加
              SafeDockerUser sfu = new SafeDockerUser();
              sfu.setContainerId(containerId);
              sfu.setCreateTime(new Date());
              sfu.setPort(port);
              sfu.setIntro(introText);
              sfu.setDockerName(uuid);
              // 以下为单独添加的内容
              sfu.setUserId(loginUser.getUser().getId());
              sfu.setLabId(safeLabs.getId());
              sfu.setDockerId(safeDocker.getId());
              sfu.setIsExist(1);
              sfu.setIsSuccess(0);
              sfu.setExpTime(DateUtil.getAfterDate(new Date(),0,0,0,0,expireTime,0));

              safeDockerUserMapper.insert(sfu);
          }


          // 增加靶场记录
          SafeLabsRecord safeLabsRecord = new SafeLabsRecord();
          safeLabsRecord.setCreateTime(new Date());
          safeLabsRecord.setEndTime(DateUtil.getAfterDate(new Date(),0,0,0,0,expireTime,0));
          safeLabsRecord.setUserId(loginUser.getUser().getId());
          safeLabsRecord.setLabId(safeLabs.getId());
          safeLabsRecord.setIsSuccess(0);
          safeLabsRecord.setDockerName(uuid);
          safeLabsRecordService.save(safeLabsRecord);

          map.put("intro", introText);
          map.put("expTime", expireTime * 60);
          map.put("isExist",1);
          resultMap.put("data",map);
          return R.ok(resultMap);
      }catch (Exception e){
          System.out.println(e.getMessage());
          // 事务回滚
          TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
          return R.error();
      }
    }

    @Override
    public R submitFlag(SubmitFlagParamsDto submitFlagParamsDto) {
        try {
            LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            SafeLabs safeLabs = safeLabsMapper.selectOne(new QueryWrapper<SafeLabs>().eq("id", submitFlagParamsDto.getLabId()));
            if(!safeLabs.getFlag().equals(submitFlagParamsDto.getFlag())){
                return R.error("Flag错误，但请不要灰心，继续努力！");
            }
            // 查看历史记录，决定是否增加金币
            SafeDockerUser safeDockerUser = safeDockerUserMapper.selectOne(new QueryWrapper<SafeDockerUser>().eq("user_id", loginUser.getUser().getId()).eq("lab_id",safeLabs.getId()));
            if(safeDockerUser.getIsSuccess() == 1){
                // 修改靶场记录
                updateSuccessLabRecord(safeDockerUser.getDockerName());
                return R.ok("Flag正确，但您已解出过这道题了，所以此次不增加金币~");
            }else{
                // 增加金币
                User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", loginUser.getUser().getId()));
                user.setCoin(user.getCoin() + safeLabs.getGoldCoin());
                userMapper.updateById(user);
                // 修改成功状态
                safeDockerUser.setIsSuccess(1);
                safeDockerUserMapper.updateById(safeDockerUser);
                // 修改靶场记录
                updateSuccessLabRecord(safeDockerUser.getDockerName());
                return R.ok("恭喜你，成功解出这道题~");
            }

        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R getList(Integer currentPage, Integer pageSize) {
        try {
            Page<SafeLabs> page = new Page<>(currentPage, pageSize);
            QueryWrapper<SafeLabs> wrapper = new QueryWrapper<>();

            Page<SafeLabs> safeLabsPage = safeLabsMapper.selectPage(page, wrapper);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("data", safeLabsPage.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(page));

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    // 增加挑战成功记录
    public R updateSuccessLabRecord(String dockerName){
        try {
            // 修改靶场记录
            UpdateWrapper<SafeLabsRecord> safeLabsRecordUpdateWrapper = new UpdateWrapper<>();
            safeLabsRecordUpdateWrapper.eq("docker_name", dockerName);
            safeLabsRecordUpdateWrapper.set("is_success", 1);
            safeLabsRecordService.update(safeLabsRecordUpdateWrapper);
            return R.ok();
        }catch (Exception e){
            return R.error();
        }
    }


    // 后台部分

    @Override
    public R getList(Integer currentPage, Integer pageSize, String keywords, Integer type) {
        try {
            QueryWrapper<SafeLabs> wrapper = new QueryWrapper<>();
            Page<SafeLabs> page = new Page<>(currentPage, pageSize);
            if(keywords != null){
                wrapper.like("title", keywords);
            }
            if(type != null){
                wrapper.eq("sort_id", type);
            }

            Page<SafeLabs> labsPage = safeLabsMapper.selectPage(page, wrapper);


            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", labsPage.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(labsPage));
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R deleteById(Integer id) {
        try {
            QueryWrapper<SafeLabs> wrapper = new QueryWrapper<>();
            wrapper.eq("id", id);
            safeLabsMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

    @Override
    public R deleteListById(String ids) {
        try {
            QueryWrapper<SafeLabs> wrapper = new QueryWrapper<>();
            wrapper.in("id", ids.split(","));
            safeLabsMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

}
