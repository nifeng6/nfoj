package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.entity.AdminMenu;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.Role;
import com.jishu5.ctfcommunityserver.entity.RoleMenu;
import com.jishu5.ctfcommunityserver.mapper.AdminMenuMapper;
import com.jishu5.ctfcommunityserver.mapper.RoleMapper;
import com.jishu5.ctfcommunityserver.mapper.RoleMenuMapper;
import com.jishu5.ctfcommunityserver.service.RoleService;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private AdminMenuMapper adminMenuMapper;

    @Override
    public R getList(Integer currentPage, Integer pageSize, String keywords) {
        try {
            Page<Role> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Role> wrapper = new QueryWrapper<>();
            Page<Role> rolePage = roleMapper.selectPage(page, wrapper);

            for (Role role : rolePage.getRecords()){
                List<Integer> menuIdListByRoleId = roleMenuMapper.getMenuIdListByRoleId(role.getId());
                role.setAdminMenuIdList(menuIdListByRoleId);

            }

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", rolePage.getRecords());

            resultMap.put("page", DtoUtils.pageDtoHandle(rolePage));

            return R.ok(resultMap);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return R.error();
        }
    }

    @Override
    public R getMenuList() {
        try {
            QueryWrapper<AdminMenu> wrapper = new QueryWrapper<>();
            wrapper.eq("parent_id", 0);
            List<AdminMenu> adminMenuList = adminMenuMapper.selectList(wrapper);

            for (AdminMenu adminMenu : adminMenuList){

                if(adminMenu.getMenuType().equals("M")){
                    QueryWrapper<AdminMenu> childWrapper = new QueryWrapper<>();
                    childWrapper.eq("menu_type", "C");
                    childWrapper.eq("parent_id", adminMenu.getId());
                    List<AdminMenu> childMenuList = adminMenuMapper.selectList(childWrapper);
                    adminMenu.setChildMenuList(childMenuList);

                    for (AdminMenu childMenu : childMenuList){
                        if (childMenu.getMenuType().equals("C")){
                            childMenu.setChildMenuList(getTypeB(childMenu));
                        }
                    }
                }else if(adminMenu.getMenuType().equals("C")){
                    adminMenu.setChildMenuList(getTypeB(adminMenu));
                }

            }

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", adminMenuList);


            return R.ok(resultMap);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return R.error();
        }
    }

    // 遍历类型为C菜单底下的按钮
    public List<AdminMenu> getTypeB(AdminMenu adminMenu){
        QueryWrapper<AdminMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("menu_type","B");
        wrapper.eq("parent_id", adminMenu.getId());
        List<AdminMenu> adminMenuList = adminMenuMapper.selectList(wrapper);

        return adminMenuList;
    }


    @Override
    public R deleteById(Integer id) {
        try {
            QueryWrapper<Role> wrapper = new QueryWrapper<>();
            wrapper.eq("id", id);
            roleMapper.delete(wrapper);
            return R.ok("角色删除成功");
        }catch (Exception e){
            return R.error("角色删除失败");
        }
    }

    @Override
    public R deleteListById(String ids) {
        try {
            QueryWrapper<Role> wrapper = new QueryWrapper<>();
            wrapper.in("id", ids.split(","));
            roleMapper.delete(wrapper);
            return R.ok("角色删除成功");
        }catch (Exception e){
            return R.error("角色删除失败");
        }
    }

    @Override
    public R addRole(Role role) {
        try {
            // 查询是否重复
            Role roleExist = roleMapper.selectOne(new QueryWrapper<Role>().eq("role_key", role.getRoleKey()));
            if(roleExist != null){
                return R.error("该角色已存在，请更换唯一标识");
            }
            // 增加角色
            role.setCreateTime(new Date());
            role.setUpdateTime(new Date());
            roleMapper.insert(role);
            // 查询角色id
            Role roleIdEntity = roleMapper.selectOne(new QueryWrapper<Role>().eq("role_key", role.getRoleKey()));

            // 循环添加菜单权限
            for (Integer menuId : role.getAdminMenuIdList()){
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(roleIdEntity.getId());
                roleMenu.setMenuId(menuId);
                roleMenuMapper.insert(roleMenu);
            }

            return R.ok("角色添加成功");
        }catch (Exception e){
            return R.error("角色添加失败");
        }
    }

    @Override
    public R updateRole(Role role) {
        try {
            // 删除所有权限
            roleMenuMapper.delete(new QueryWrapper<RoleMenu>().in("role_id", role.getId()));
            // 循环添加菜单权限
            for (Integer menuId : role.getAdminMenuIdList()){
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(role.getId());
                roleMenu.setMenuId(menuId);
                roleMenuMapper.insert(roleMenu);
            }

            role.setUpdateTime(new Date());
            roleMapper.updateById(role);
            return R.ok("角色更新成功");
        }catch (Exception e){
            return R.error("角色更新失败");
        }
    }
}
