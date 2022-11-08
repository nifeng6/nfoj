package com.jishu5.ctfcommunityserver.controller.index;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.entity.Article;
import com.jishu5.ctfcommunityserver.entity.ArticleSort;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.service.ArticleService;
import com.jishu5.ctfcommunityserver.service.ArticleSortService;
import com.jishu5.ctfcommunityserver.service.impl.ArticleReplyServiceImpl;
import com.jishu5.ctfcommunityserver.service.impl.ArticleServiceImpl;
import com.jishu5.ctfcommunityserver.service.impl.ArticleSortServiceImpl;
import com.jishu5.ctfcommunityserver.service.impl.ArticleTagsServiceImpl;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index/bbs")
public class IndexBbsController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleSortService articleSortService;


    @GetMapping("/list")
    public R list(Integer currentPage, Integer pageSize, String keywords, Integer type){
        return articleService.getArticleList(currentPage,pageSize,keywords,type);
    }


    @GetMapping("/type/list")
    public R TypeList(){
        return articleSortService.getArticleTypeList();
    }


}
