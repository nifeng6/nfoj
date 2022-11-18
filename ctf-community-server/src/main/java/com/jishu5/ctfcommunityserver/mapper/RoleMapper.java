package com.jishu5.ctfcommunityserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jishu5.ctfcommunityserver.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    @Select("select * from role where id=(select role_id from user_role where user_id=${user_id})")
    Role getRoleByUserId(Integer user_id);

}
