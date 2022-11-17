package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.AdminMenu;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.Role;
import com.jishu5.ctfcommunityserver.mapper.AdminMenuMapper;
import com.jishu5.ctfcommunityserver.service.AdminMenuService;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
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
            wrapper.eq("menu_type", "M");

            wrapper.last(preSql);

            List<AdminMenu> adminMenuList = adminMenuMapper.selectList(wrapper);

            for (AdminMenu adminMenu: adminMenuList){
                QueryWrapper<AdminMenu> childWrapper = new QueryWrapper<>();
                childWrapper.eq("parent_id", adminMenu.getId());
                childWrapper.eq("menu_type", "C");
                childWrapper.last(preSql);

                List<AdminMenu> childMenuList = adminMenuMapper.selectList(childWrapper);
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

    @Override
    public R getList(Integer currentPage, Integer pageSize, String keywords) {
        try {
            Page<AdminMenu> page = new Page<>(currentPage, pageSize);
            QueryWrapper<AdminMenu> wrapper = new QueryWrapper<>();
            wrapper.eq("menu_type", "M");
            wrapper.eq("parent_id", 0);
            Page<AdminMenu> menuPage = adminMenuMapper.selectPage(page, wrapper);

            for (AdminMenu adminMenu : menuPage.getRecords()){
                QueryWrapper<AdminMenu> childWrapper = new QueryWrapper<>();
                childWrapper.eq("menu_type", "C");
                childWrapper.eq("parent_id", adminMenu.getId());
                List<AdminMenu> childMenuList = adminMenuMapper.selectList(childWrapper);
                adminMenu.setChildMenuList(childMenuList);
            }

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", menuPage.getRecords());

            resultMap.put("page", DtoUtils.pageDtoHandle(menuPage));

            return R.ok(resultMap);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return R.error();
        }
    }


    @Override
    public R deleteById(Integer id) {
        try {
            QueryWrapper<AdminMenu> wrapper = new QueryWrapper<>();
            wrapper.eq("id", id);
            adminMenuMapper.delete(wrapper);
            return R.ok("角色删除成功");
        }catch (Exception e){
            return R.error("角色删除失败");
        }
    }

    @Override
    public R deleteListById(String ids) {
        try {
            QueryWrapper<AdminMenu> wrapper = new QueryWrapper<>();
            wrapper.in("id", ids.split(","));
            adminMenuMapper.delete(wrapper);
            return R.ok("角色删除成功");
        }catch (Exception e){
            return R.error("角色删除失败");
        }
    }

    @Override
    public R addMenu(AdminMenu adminMenu) {
        try {
            adminMenu.setCreateTime(new Date());
            adminMenu.setUpdateTime(new Date());
            adminMenuMapper.insert(adminMenu);

            return R.ok("角色添加成功");
        }catch (Exception e){
            return R.error("角色添加失败");
        }
    }

    @Override
    public R updateMenu(AdminMenu adminMenu) {
        try {
            adminMenu.setUpdateTime(new Date());
            adminMenuMapper.updateById(adminMenu);
            return R.ok("角色更新成功");
        }catch (Exception e){
            return R.error("角色更新失败");
        }
    }


}
