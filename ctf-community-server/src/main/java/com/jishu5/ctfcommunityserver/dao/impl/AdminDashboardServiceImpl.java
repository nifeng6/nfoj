package com.jishu5.ctfcommunityserver.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.dao.AdminDashboardService;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeLabsRecord;
import com.jishu5.ctfcommunityserver.service.ArticleService;
import com.jishu5.ctfcommunityserver.service.SafeLabsRecordService;
import com.jishu5.ctfcommunityserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminDashboardServiceImpl implements AdminDashboardService {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private SafeLabsRecordService safeLabsRecordService;

    @Override
    public R getCountList(){
        try {
            SimpleDateFormat todayFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            String timeDay = todayFormat.format(calendar.getTime());
            Date date = todayFormat.parse(timeDay + " 00:00:00");

            int articleCount = articleService.count();
            int userCount = userService.count();
            int todayRecordCount = safeLabsRecordService.count(new QueryWrapper<SafeLabsRecord>().ge("create_time", date));

            Map<String, Object> map = new HashMap<>();
            Map<String, Object> resultMap = new HashMap<>();

            map.put("todayRecordCount", todayRecordCount);
            map.put("userCount", userCount);
            map.put("articleCount", articleCount);

            resultMap.put("data", map);

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }


}
