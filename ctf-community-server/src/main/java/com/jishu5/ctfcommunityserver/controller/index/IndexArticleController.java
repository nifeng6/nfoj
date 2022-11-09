package com.jishu5.ctfcommunityserver.controller.index;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.service.ArticleService;
import com.jishu5.ctfcommunityserver.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index/article")
public class IndexArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/detail")
    public R getDetail(Integer id){
        return articleService.getDetail(id);
    }

}
