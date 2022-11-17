package com.jishu5.ctfcommunityserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.Role;

public interface RoleService extends IService<Role> {

    public R getList(Integer currentPage, Integer pageSize, String keywords);

    public R deleteById(Integer id);

    public R deleteListById(String ids);

    public R addRole(Role role);

    public R updateRole(Role role);

}
