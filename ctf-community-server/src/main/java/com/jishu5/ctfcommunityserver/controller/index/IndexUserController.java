package com.jishu5.ctfcommunityserver.controller.index;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.service.ArticleService;
import com.jishu5.ctfcommunityserver.service.SafeDockerUserService;
import com.jishu5.ctfcommunityserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index/user")
public class IndexUserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SafeDockerUserService safeDockerUserService;

    @RequestMapping("/info")
    public R info(Integer id){
        return userService.getUserInfo(id);
    }

    @RequestMapping("/record")
    public R record(Integer id){
        return userService.getUserRecord(id);
    }

    @GetMapping("/article/list")
    public R getArticleList(Integer currentPage, Integer pageSize, Integer id){
        return articleService.getArticleListById(currentPage, pageSize, id);
    }

    @GetMapping("/ctf/list")
    public R getCtfList(Integer currentPage, Integer pageSize, Integer id){
        return safeDockerUserService.getListById(currentPage, pageSize, id);
    }


}
