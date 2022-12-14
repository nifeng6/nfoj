package com.jishu5.ctfcommunityserver.controller.admin;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public R getList(@RequestParam(value = "currentPage", required = true) Integer currentPage,
                     @RequestParam(value = "pageSize", required = true) Integer pageSize,
                     @RequestParam(value = "keywords", required = false) String keywords,
                     @RequestParam(value = "type", required = false) Integer type
    ){
        return userService.getList(currentPage, pageSize, keywords, type);
    }

    @PreAuthorize("hasAuthority('admin:user:delete')")
    @DeleteMapping("/delete")
    public R deleteById(@RequestParam("id") Integer id){
        return userService.deleteById(id);
    }


    @PreAuthorize("hasAuthority('admin:user:delete')")
    @DeleteMapping("/delete/list")
    public R deleteListById(@RequestParam("ids") String ids){
        return userService.deleteListById(ids);
    }

    @PreAuthorize("hasAuthority('admin:user:add')")
    @PostMapping("/add")
    public R addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PreAuthorize("hasAuthority('admin:user:update')")
    @PostMapping("/update")
    public R updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

}
