package com.jishu5.ctfcommunityserver.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jishu5.ctfcommunityserver.entity.AdminMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMenuMapper extends BaseMapper<AdminMenu> {

    // 获取当前用户的角色=》权限所属菜单



    @Select("select * from admin_menu where id in (select menu_id from role_menu where role_id = (select role_id from user_role where user_id=#{id})) ${ew.customSqlSegment}")
    List<AdminMenu> getMenuListByUserId(Integer id, @Param(Constants.WRAPPER) QueryWrapper<AdminMenu> queryWrapper);


    @Select("select * from admin_menu where id in (select menu_id from role_menu where role_id = (select role_id from user_role where user_id=#{id}))")
    List<AdminMenu> getMenuListByUserId(Integer id);

}
