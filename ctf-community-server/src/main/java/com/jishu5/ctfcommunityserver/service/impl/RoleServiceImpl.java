package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.Role;
import com.jishu5.ctfcommunityserver.mapper.RoleMapper;
import com.jishu5.ctfcommunityserver.service.RoleService;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public R getList(Integer currentPage, Integer pageSize, String keywords) {
        try {
            Page<Role> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Role> wrapper = new QueryWrapper<>();
            Page<Role> rolePage = roleMapper.selectPage(page, wrapper);

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
            role.setCreateTime(new Date());
            role.setUpdateTime(new Date());
            roleMapper.insert(role);

            return R.ok("角色添加成功");
        }catch (Exception e){
            return R.error("角色添加失败");
        }
    }

    @Override
    public R updateRole(Role role) {
        try {
            role.setUpdateTime(new Date());
            roleMapper.updateById(role);
            return R.ok("角色更新成功");
        }catch (Exception e){
            return R.error("角色更新失败");
        }
    }
}
