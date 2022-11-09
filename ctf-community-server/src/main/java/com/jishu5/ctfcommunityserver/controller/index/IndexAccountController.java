package com.jishu5.ctfcommunityserver.controller.index;

import com.jishu5.ctfcommunityserver.dto.LoginDto;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.service.CoinRecordService;
import com.jishu5.ctfcommunityserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index/account")
public class IndexAccountController {

    @Autowired
    private CoinRecordService coinRecordService;

    @Autowired
    private UserService userService;

    @GetMapping("/coinRecord/list")
    public R getCoinRecordList(Integer currentPage, Integer pageSize){
        // 根据token中的id获取列表
        return coinRecordService.getList(currentPage, pageSize);
    }

    @PostMapping("/qiandao")
    public R getQiandao(){
        return userService.qiandao();
    }


}
