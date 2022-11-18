package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.entity.RoleMenu;
import com.jishu5.ctfcommunityserver.mapper.RoleMenuMapper;
import com.jishu5.ctfcommunityserver.service.RoleMenuService;
import org.springframework.stereotype.Service;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
}
