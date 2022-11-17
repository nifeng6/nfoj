package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.AdminMenu;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.mapper.AdminMenuMapper;
import com.jishu5.ctfcommunityserver.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminMenuServiceImpl extends ServiceImpl<AdminMenuMapper, AdminMenu> implements AdminMenuService {

    @Autowired
    private AdminMenuMapper adminMenuMapper;

    @Override
    public R getList() {
        try {
            LoginUser loginUser =  (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Integer userId = loginUser.getUser().getId();

            String preSql = " and id in (select menu_id from role_menu where role_id = (select role_id from user_role where user_id="+userId+"))";

            QueryWrapper<AdminMenu> wrapper = new QueryWrapper<>();
            wrapper.eq("parent_id", 0);

            wrapper.last(preSql);

            List<AdminMenu> adminMenuList = adminMenuMapper.selectList(wrapper);

            for (AdminMenu adminMenu: adminMenuList){
                List<AdminMenu> childMenuList = adminMenuMapper.selectList(new QueryWrapper<AdminMenu>().eq("parent_id", adminMenu.getId()).last(preSql));
                adminMenu.setChildMenuList(childMenuList);
            }

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("data", adminMenuList);

            return R.ok(resultMap);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return R.error();
        }
    }
}
