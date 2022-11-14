package com.jishu5.ctfcommunityserver.controller.index;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeLabsRecord;
import com.jishu5.ctfcommunityserver.mapper.ArticleMapper;
import com.jishu5.ctfcommunityserver.service.ArticleService;
import com.jishu5.ctfcommunityserver.service.SafeLabsRecordService;
import com.jishu5.ctfcommunityserver.service.SafeLabsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index/home")
public class IndexHomeController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SafeLabsRecordService safeLabsRecordService;

    @Autowired
    private SafeLabsService safeLabsService;

    @GetMapping("/notice/list")
    public R getNoticeList(Integer currentPage, Integer pageSize){
        return articleService.getNoticeList(currentPage, pageSize);
    }

    @GetMapping("/dynamic/list")
    public R getDynamicList(Integer currentPage, Integer pageSize){
        return safeLabsRecordService.getList(currentPage, pageSize);
    }

    @GetMapping("/lab/list")
    public R getLabsList(Integer currentPage, Integer pageSize){
        return safeLabsService.getList(currentPage, pageSize);
    }

    @GetMapping("/week/record")
    public R getWeekRecord(){
        return safeLabsRecordService.getWeekRecord();
    }

}
