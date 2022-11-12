package com.jishu5.ctfcommunityserver.controller.common;

import com.jishu5.ctfcommunityserver.dao.EmailService;
import com.jishu5.ctfcommunityserver.dao.LoginService;
import com.jishu5.ctfcommunityserver.dto.params.index.EmailSendParams;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.service.UserService;
import com.jishu5.ctfcommunityserver.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/common/account")
public class AccountController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/login")
    public R login(@RequestBody User user){
        return loginService.login(user);
    }

    @PostMapping("/register")
    public R register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/logout")
    public R logout(){
        return loginService.logout();
    }

    @PostMapping("/info")
    public R getInfo(){
        return loginService.getInfo();
    }

    @PostMapping("/update")
    public R updateInfo(@RequestBody User user){
        return userService.updateInfo(user);
    }

    // 注册邮箱验证码发送
    @PostMapping("/register/email")
    public R registerEmailSend(@RequestBody EmailSendParams emailSendParams){
        return emailService.registerEmail(emailSendParams);
    }


    @PreAuthorize("hasAuthority('test')")
    @GetMapping("/hello")
    public R hello(){
        return R.ok("hello");
    }


}
