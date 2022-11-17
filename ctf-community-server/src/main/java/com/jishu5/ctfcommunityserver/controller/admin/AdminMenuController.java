package com.jishu5.ctfcommunityserver.controller.admin;

import com.jishu5.ctfcommunityserver.entity.AdminMenu;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.service.AdminMenuService;
import com.jishu5.ctfcommunityserver.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/menu")
public class AdminMenuController {

    @Autowired
    private AdminMenuService adminMenuService;

    @GetMapping("/role-list")
    public R getList(){
        return adminMenuService.getList();
    }

    @GetMapping("/list")
    public R getList(Integer currentPage, Integer pageSize,
                     @RequestParam(value = "keywords", required = false) String keywords){
        return adminMenuService.getList(currentPage, pageSize, keywords);
    }



    @DeleteMapping("/delete")
    public R deleteById(@RequestParam("id") Integer id){
        return adminMenuService.deleteById(id);
    }

    @PostMapping("/add")
    public R addTools(@RequestBody AdminMenu adminMenu){
        return adminMenuService.addMenu(adminMenu);
    }

    @PostMapping("/update")
    public R updateTools(@RequestBody AdminMenu adminMenu){
        return adminMenuService.updateMenu(adminMenu);
    }



}
