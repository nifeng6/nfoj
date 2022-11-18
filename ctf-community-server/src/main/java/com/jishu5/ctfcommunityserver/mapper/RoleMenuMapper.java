package com.jishu5.ctfcommunityserver.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jishu5.ctfcommunityserver.entity.RoleMenu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    @Select("select menu_id from role_menu where role_id=${role_id}")
    List<Integer> getMenuIdListByRoleId(Integer role_id);
}
