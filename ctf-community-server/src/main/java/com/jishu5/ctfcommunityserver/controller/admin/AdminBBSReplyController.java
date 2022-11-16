package com.jishu5.ctfcommunityserver.controller.admin;

import com.jishu5.ctfcommunityserver.entity.ArticleReply;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.service.ArticleReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/bbs/reply")
public class AdminBBSReplyController {

    @Autowired
    private ArticleReplyService articleReplyService;

    @GetMapping("/list")
    public R getList(@RequestParam(value = "currentPage", required = true) Integer currentPage,
                            @RequestParam(value = "pageSize", required = true) Integer pageSize,
                            @RequestParam(value = "keywords", required = false) String keywords,
                            @RequestParam(value = "type", required = false) Integer type
    ){
        return articleReplyService.getReplyList(currentPage, pageSize, keywords, type);
    }

    @DeleteMapping("/delete")
    public R deleteById(@RequestParam("id") Integer id){
        return articleReplyService.deleteReplyById(id);
    }


    @DeleteMapping("/delete/list")
    public R deleteListById(@RequestParam("ids") String ids){
        return articleReplyService.deleteReplyListById(ids);
    }

    @PostMapping("/update")
    public R updateReplyById(@RequestBody ArticleReply articleReply){
        return articleReplyService.updateReplyById(articleReply);
    }

}
