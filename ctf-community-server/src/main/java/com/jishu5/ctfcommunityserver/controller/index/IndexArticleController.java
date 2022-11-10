package com.jishu5.ctfcommunityserver.controller.index;

import com.jishu5.ctfcommunityserver.dto.AddReplyDto;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.service.ArticleReplyService;
import com.jishu5.ctfcommunityserver.service.ArticleService;
import com.jishu5.ctfcommunityserver.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index/article")
public class IndexArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleReplyService articleReplyService;

    @GetMapping("/detail")
    public R getDetail(Integer id){
        return articleService.getDetail(id);
    }

    @GetMapping("/reply/list")
    public R replyList(Integer currentPage, Integer pageSize, Integer id){
        return articleService.getReplyList(currentPage, pageSize, id);
    }

    @PostMapping("/reply/add")
    public R addReply(@RequestBody AddReplyDto addReplyDto){
        return articleReplyService.addReply(addReplyDto);
    }

}
