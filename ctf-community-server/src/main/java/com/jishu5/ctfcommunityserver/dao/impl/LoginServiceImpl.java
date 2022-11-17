package com.jishu5.ctfcommunityserver.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.controller.common.UtilController;
import com.jishu5.ctfcommunityserver.dao.LoginService;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.mapper.UserMapper;
import com.jishu5.ctfcommunityserver.utils.JwtUtil;
import com.jishu5.ctfcommunityserver.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
//
    @Resource
    private UtilController checkCode;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserMapper userMapper;

    @Override
    public R login(User user) {
        // 判断验证码是否正确
        String captchaCode = checkCode.getCheckCode();
        String rightCode = user.getCaptchaCode();
        if (!captchaCode.equals(rightCode)){
            return R.error("验证码输入错误！");
        }

        System.out.println(1);
        //使用Authentication的实现类
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        System.out.println(2);

        //手动调用方法去认证 他会自动调用UserDetailsService查 然后对比啥的
        Authentication authenticate = authenticationManager.authenticate(authentication);
        System.out.println(3);

        if(Objects.isNull(authenticate)){ //说明输入错误
            throw new RuntimeException("用户名或密码错误");
        }
        //拿到用户信息 然后生成jwt返回给前端，并且将用户的信息存入redis
        LoginUser loginUser = (LoginUser)authenticate.getPrincipal(); // 这个其实就是UserDetails 也就是LoginUser
        String userId = loginUser.getUser().getId().toString();

        String jwt = JwtUtil.createJWT(userId);

        redisCache.setCacheObject("login:"+userId,loginUser);//将用户信息直接存入redis

        Map<String, Object> map = new HashMap<>();
        map.put("token",jwt);

        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("data", map);
        resultMap.put("msg", "登录成功");
        return R.ok(resultMap);
    }

    @Override
    public R logout() {
        //因为这个方法 是通过了jwt过滤器执行到这里的 所以SecurityContextHolder上下文是一样的
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //拿到用户id删除redis中的数据
        String userId  = loginUser.getUser().getId().toString();
        redisCache.deleteObject("login:"+userId);
        return R.ok("退出成功");
    }

    @Override
    public R getInfo() {
        try {
            LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            User user = userMapper.selectOne(new QueryWrapper<User>().eq("id",loginUser.getUser().getId()));
            Map<String,Object> resultMap = new HashMap<>();
            Map<String,Object> map = new HashMap<>();
            map.put("user", user);
            map.put("permission", loginUser.getPermission());

            resultMap.put("data",map);
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

}

