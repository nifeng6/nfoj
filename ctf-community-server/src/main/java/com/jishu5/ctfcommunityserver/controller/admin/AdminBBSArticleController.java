package com.jishu5.ctfcommunityserver.controller.admin;

import com.jishu5.ctfcommunityserver.entity.Article;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.service.ArticleService;
import com.jishu5.ctfcommunityserver.service.ArticleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/bbs/article")
public class AdminBBSArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleSortService articleSortService;

    @GetMapping("/list")
    public R getArticleList(@RequestParam(value = "currentPage", required = true) Integer currentPage,
                            @RequestParam(value = "pageSize", required = true) Integer pageSize,
                            @RequestParam(value = "keywords", required = false) String keywords,
                            @RequestParam(value = "type", required = false) Integer type,
                            @RequestParam(value = "createTime", required = false) String createTime
                            ){
        return articleService.getArticleList(currentPage, pageSize, keywords, type, createTime);
    }

    @DeleteMapping("/delete")
    public R deleteArticleById(@RequestParam("id") Integer id){
        return articleService.deleteArticleById(id);
    }

    @DeleteMapping("/delete/list")
    public R deleteArticleListById(@RequestParam("ids") String ids){
        return articleService.deleteArticleListById(ids);
    }

    @GetMapping("/type/list")
    public R getArticleTypeList(){
        return articleSortService.getArticleTypeList();
    }

    @PostMapping("/add")
    public R addArticle(@RequestBody Article article){
        return articleService.addArticle(article);
    }

    @PostMapping("/update")
    public R updateArticle(@RequestBody Article article){
        return articleService.updateArticle(article);
    }
}
