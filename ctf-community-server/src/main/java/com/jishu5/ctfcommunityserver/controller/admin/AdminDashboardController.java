package com.jishu5.ctfcommunityserver.controller.admin;

import com.jishu5.ctfcommunityserver.dao.AdminDashboardService;
import com.jishu5.ctfcommunityserver.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/dashboard")
public class AdminDashboardController {

    @Autowired
    private AdminDashboardService adminDashboardService;

    @GetMapping("/count-list")
    public R getCountList(){
        return adminDashboardService.getCountList();
    }


}
