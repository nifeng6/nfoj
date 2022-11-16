package com.jishu5.ctfcommunityserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jishu5.ctfcommunityserver.entity.AdminMenu;
import com.jishu5.ctfcommunityserver.entity.R;

public interface AdminMenuService extends IService<AdminMenu> {

    public R getList();

}
