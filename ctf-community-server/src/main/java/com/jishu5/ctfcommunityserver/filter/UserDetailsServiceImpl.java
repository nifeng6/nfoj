package com.jishu5.ctfcommunityserver.filter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.service.AdminMenuService;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.AdminMenu;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminMenuService adminMenuService;

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

        // 根据用户名获取用户权限
        String lastSql = " and id in (select menu_id from role_menu where role_id = (select role_id from user_role where user_id=(select id from user where username=\""+username+"\")))";

        QueryWrapper<AdminMenu> roleMenuWrapper = new QueryWrapper<>();

        roleMenuWrapper.eq("menu_type", "B");

        roleMenuWrapper.last(lastSql);

        List<AdminMenu> adminMenuList = adminMenuService.list(roleMenuWrapper);

        //传递用户所具有的权限
        List<String> permissions = new ArrayList<>();
        permissions.add("test");
        // 循环添加权限
        for (AdminMenu adminMenu : adminMenuList){
            System.out.println(adminMenu.getPermission());
            permissions.add(adminMenu.getPermission());
        }

        System.out.println(permissions);

//        permissions.add("test");
        return new LoginUser(user, permissions);
    }
}
