package com.jishu5.ctfcommunityserver.controller.common;

import com.jishu5.ctfcommunityserver.dao.LoginService;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common/account")
public class AccountController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public R login(@RequestBody User user){
        return loginService.login(user);
    }

    @PostMapping("/logout")
    public R logout(){
        return loginService.logout();
    }

    @PostMapping("/info")
    public R getInfo(){
        return loginService.getInfo();
    }



    @PreAuthorize("hasAuthority('test')")
    @GetMapping("/hello")
    public R hello(){
        return R.ok("hello");
    }
}
