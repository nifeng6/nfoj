package com.jishu5.ctfcommunityserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jishu5.ctfcommunityserver.entity.AdminMenu;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.Role;

public interface AdminMenuService extends IService<AdminMenu> {

    public R getList();

    public R getList(Integer currentPage, Integer pageSize, String keywords);

    public R deleteById(Integer id);

    public R addMenu(AdminMenu adminMenu);

    public R updateMenu(AdminMenu adminMenu);

}
