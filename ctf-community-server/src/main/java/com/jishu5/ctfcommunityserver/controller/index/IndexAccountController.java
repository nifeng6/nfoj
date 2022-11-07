package com.jishu5.ctfcommunityserver.controller.index;

import com.jishu5.ctfcommunityserver.dto.LoginDto;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index/account")
public class IndexAccountController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

}
