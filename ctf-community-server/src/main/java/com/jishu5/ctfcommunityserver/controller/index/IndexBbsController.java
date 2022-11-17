package com.jishu5.ctfcommunityserver.controller.index;


import com.jishu5.ctfcommunityserver.entity.Article;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.service.ArticleService;
import com.jishu5.ctfcommunityserver.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index/bbs")
public class IndexBbsController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleTypeService articleSortService;


    @GetMapping("/list")
    public R list(Integer currentPage, Integer pageSize, String keywords, Integer type){
        return articleService.getArticleList(currentPage,pageSize,keywords,type);
    }

    @GetMapping("/type/list")
    public R TypeList(){
        return articleSortService.getArticleTypeList();
    }

    @PostMapping("/add")
    public R add(@RequestBody Article article){
        return articleService.addArticle(article);
    }


}
