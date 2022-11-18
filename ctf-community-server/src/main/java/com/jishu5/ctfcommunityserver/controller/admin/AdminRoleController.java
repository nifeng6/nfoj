package com.jishu5.ctfcommunityserver.controller.admin;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.Role;
import com.jishu5.ctfcommunityserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/role")
public class AdminRoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public R getList(Integer currentPage, Integer pageSize,
                     @RequestParam(value = "keywords", required = false) String keywords){
        return roleService.getList(currentPage, pageSize, keywords);
    }

    @GetMapping("/menu-list")
    public R getMenuList(){
        return roleService.getMenuList();
    }

    @PreAuthorize("hasAuthority('admin:role:delete')")
    @DeleteMapping("/delete")
    public R deleteById(@RequestParam("id") Integer id){
        return roleService.deleteById(id);
    }

    @PreAuthorize("hasAuthority('admin:role:delete')")
    @DeleteMapping("/delete/list")
    public R deleteListById(@RequestParam("ids") String ids){
        return roleService.deleteListById(ids);
    }

    @PreAuthorize("hasAuthority('admin:role:add')")
    @PostMapping("/add")
    public R addTools(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @PreAuthorize("hasAuthority('admin:role:update')")
    @PostMapping("/update")
    public R updateTools(@RequestBody Role role){
        return roleService.updateRole(role);
    }


}
