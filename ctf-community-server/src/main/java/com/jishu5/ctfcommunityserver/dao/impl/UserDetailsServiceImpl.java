package com.jishu5.ctfcommunityserver.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isBlank(username)){
            throw new RuntimeException("请输入用户名");
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).last("limit 1");
        User user = userMapper.selectOne(wrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名不存在");
        }
        //传递用户所具有的权限
        List<String> list = new ArrayList<>(Arrays.asList("test", "admin123"));
        return new LoginUser(user, list);
    }
}
