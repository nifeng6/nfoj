package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.dto.LoginDto;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.*;
import com.jishu5.ctfcommunityserver.mapper.*;
import com.jishu5.ctfcommunityserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.utils.RedisCache;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private SafeDockerUserMapper safeDockerUserMapper;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private CoinRecordMapper coinRecordMapper;

    @Override
    public R getUserInfo(Integer user_id) {
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("id",user_id);
            User user = userMapper.selectOne(wrapper);

            Map<String, Object> map = new HashMap<>();
            Map<String, Object> resultMap = new HashMap<>();

            map.put("id", user.getId());
            map.put("username", user.getUsername());
            map.put("createTime",user.getCreateTime());

            resultMap.put("data", map);
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R getUserRecord(Integer user_id) {
        try {

            Integer articleCount = articleMapper.selectCount(new QueryWrapper<Article>().eq("user_id",user_id));
            Integer coinCount = userMapper.selectOne(new QueryWrapper<User>().eq("id",user_id)).getCoin();
            Integer safeRecordCount = safeDockerUserMapper.selectCount(new QueryWrapper<SafeDockerUser>().eq("user_id",user_id));
            Map<String, Object> map = new HashMap<>();
            map.put("articleCount", articleCount);
            map.put("safeRecordCount", safeRecordCount);
            map.put("coinCount", coinCount);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("data", map);
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R updateInfo(User user) {
        try {
            LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(!loginUser.getUser().getId().equals(user.getId())){
                return R.error("异常修改，系统已记录您的IP地址！");
            }

            int updateById = userMapper.updateById(user);

            if(updateById == 1){
                loginUser.setUser(user);
                redisCache.setCacheObject("login:"+user.getId(), loginUser);//将用户信息直接存入redis
                return R.ok("更新成功");
            }
            return R.error("更新失败");
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R updatePassword(User user) {
        try {

            return R.ok();
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    @Transactional
    public R qiandao() {
        try {
            LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            // 判断用户当天是否签到
            Object time = redisCache.getCacheObject("user:qiandao" + loginUser.getUser().getId());
            Date currentDate = new Date();
            if(time == null){
                return qiandaoFn(loginUser);
            }else{
                Date redisDate = new Date(Long.parseLong(time.toString()));
                if (DateUtils.isSameDay(redisDate, currentDate)){
                    return R.error("今日已签到");
                }
                return qiandaoFn(loginUser);
            }
        }catch (Exception e){
            // 事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.error();
        }
    }

    // 执行签到逻辑
    public R qiandaoFn(LoginUser loginUser){
        // 增加的金币
        Integer coin = 10;
        // 增加用户表金币
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", loginUser.getUser().getId()));
        Integer count = user.getCoin() + coin;
        user.setCoin(count);
        userMapper.updateById(user);
        // 增加金币记录
        CoinRecord coinRecord = new CoinRecord();
        coinRecord.setAmount(coin);
        coinRecord.setCount(count);
        coinRecord.setCreateTime(new Date());
        coinRecord.setUserId(user.getId());
        coinRecord.setRemark("网站签到");
        coinRecordMapper.insert(coinRecord);

        // redis增加当天签到记录
        redisCache.setCacheObject("user:qiandao"+user.getId(), new Date().getTime());

        return R.ok("签到成功");
    }


}
