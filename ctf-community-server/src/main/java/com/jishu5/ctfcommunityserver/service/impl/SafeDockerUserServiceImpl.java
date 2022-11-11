package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.params.index.CloseLabParamsDto;
import com.jishu5.ctfcommunityserver.dto.params.index.LabDetailParamsDto;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeDockerUser;
import com.jishu5.ctfcommunityserver.entity.SafeLabs;
import com.jishu5.ctfcommunityserver.entity.SafeType;
import com.jishu5.ctfcommunityserver.mapper.SafeDockerUserMapper;
import com.jishu5.ctfcommunityserver.service.SafeDockerUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.service.SafeLabsService;
import com.jishu5.ctfcommunityserver.service.SafeTypeService;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import com.jishu5.ctfcommunityserver.utils.RedisCache;
import com.jishu5.ctfcommunityserver.utils.SSHBackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
@Service
public class SafeDockerUserServiceImpl extends ServiceImpl<SafeDockerUserMapper, SafeDockerUser> implements SafeDockerUserService {

    @Autowired
    private SafeDockerUserMapper safeDockerUserMapper;

    @Autowired
    private SafeTypeService safeTypeService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private SafeLabsService safeLabsService;

    @Autowired
    private SSHBackUtil sshBackUtil;

    @Value("${ctf.nginx-address}")
    private String nginxAddress;

    public R getListById(Integer currentPage, Integer pageSize, Integer id){
        try {
            Page<SafeDockerUser> page = new Page<>(currentPage, pageSize);
            QueryWrapper<SafeDockerUser> wrapper = new QueryWrapper<>();
            Page<SafeDockerUser> pageResult = safeDockerUserMapper.selectPage(page, wrapper);

            for (SafeDockerUser safeDockerUser : pageResult.getRecords()){
                SafeLabs safeLabs = safeLabsService.getOne(new QueryWrapper<SafeLabs>().eq("id", safeDockerUser.getLabId()));
                SafeType safeType = safeTypeService.getOne(new QueryWrapper<SafeType>().eq("id",safeLabs.getTypeId()));

                safeLabs.setType(safeType);
                safeDockerUser.setLab(safeLabs);

            }

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", pageResult.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(pageResult));

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    public R getDetailById(LabDetailParamsDto labDetailParamsDto) {
        try {
            LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            SafeDockerUser safeDockerUser = safeDockerUserMapper.selectOne(new QueryWrapper<SafeDockerUser>().eq("lab_id", labDetailParamsDto.getLabId()).eq("user_id", loginUser.getUser().getId()));
            Map<String, Object> resultMap = new HashMap<>();
            Map<String, Object> map = new HashMap<>();
            if (safeDockerUser == null){
                map.put("intro", "");
                map.put("expTime", 0);
                map.put("isExist", 0);
                resultMap.put("data", map);
                return R.ok(resultMap);
            }
            map.put("intro", safeDockerUser.getIntro());
            map.put("expTime", safeDockerUser.getExpTime().getTime() / 1000 - new Date().getTime() / 1000);
            map.put("isExist", safeDockerUser.getIsExist());
            map.put("isSuccess", safeDockerUser.getIsSuccess());
            resultMap.put("data", map);
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    public R closeLab(CloseLabParamsDto closeLabParamsDto){
        try {
            LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            SafeDockerUser safeDockerUser = safeDockerUserMapper.selectOne(new QueryWrapper<SafeDockerUser>().eq("lab_id",closeLabParamsDto.getLabId()).eq("user_id",loginUser.getUser().getId()));

            // 删除redis倒计时
            redisCache.deleteObject("codetip:safe:labs:"+safeDockerUser.getDockerName());
            // 删除容器
            sshBackUtil.sendCommand("docker rm -f "+safeDockerUser.getContainerId());
            // 删除nginx文件并重载
            sshBackUtil.sendCommand("rm -f " + nginxAddress +"/docker_proxy/"+safeDockerUser.getDockerName()+".conf");
            // 重载nginx，不然过期且的映射会报错502
            sshBackUtil.sendCommand("systemctl reload nginx");
            // 修改存在状态并更新
            safeDockerUser.setIsExist(0);
            safeDockerUserMapper.updateById(safeDockerUser);

            return R.ok();
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R closeLabByName(String dockerName) {
        try {
            SafeDockerUser safeDockerUser = safeDockerUserMapper.selectOne(new QueryWrapper<SafeDockerUser>().eq("docker_name", dockerName));

            // 删除容器
            sshBackUtil.sendCommand("docker rm -f "+safeDockerUser.getContainerId());
            // 删除nginx文件并重载
            sshBackUtil.sendCommand("rm -f " + nginxAddress +"/docker_proxy/"+safeDockerUser.getDockerName()+".conf");
            // 重载nginx，不然过期且的映射会报错502
            sshBackUtil.sendCommand("systemctl reload nginx");
            // 修改存在状态并更新
            safeDockerUser.setIsExist(0);
            safeDockerUserMapper.updateById(safeDockerUser);

            return R.ok();
        }catch (Exception e){
            return R.error();
        }
    }

}
