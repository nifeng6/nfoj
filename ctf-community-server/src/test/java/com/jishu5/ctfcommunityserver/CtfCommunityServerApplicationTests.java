package com.jishu5.ctfcommunityserver;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.entity.AdminMenu;
import com.jishu5.ctfcommunityserver.entity.SafeLabsRecord;
import com.jishu5.ctfcommunityserver.mapper.AdminMenuMapper;
import com.jishu5.ctfcommunityserver.service.SafeLabsRecordService;
import com.jishu5.ctfcommunityserver.utils.EmailUtil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CtfCommunityServerApplicationTests {

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private SafeLabsRecordService safeLabsRecordService;

    @Test
    void test2(){
        emailUtil.sendMail("194908655@qq.com","测试邮件","这是一封<h1>王熙来</h1>的测试邮件");
    }

    @Test
    void test3(){
        QueryWrapper<SafeLabsRecord> wrapper = new QueryWrapper<>();
        wrapper.le("create_time",new Date());
        int count = safeLabsRecordService.count(wrapper);
        System.out.println(count);


    }


    @Test
    void test4() throws ParseException {
        SimpleDateFormat todayFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String timeDay = todayFormat.format(calendar.getTime());
        Date date = todayFormat.parse(timeDay + " 00:00:00");

    }

    @Autowired
    private AdminMenuMapper adminMenuMapper;

    @Test
    void test5() {

//        List<AdminMenu> menuListByUserId = adminMenuMapper.getMenuListByUserId( 1,new QueryWrapper<AdminMenu>().eq("parent_id", 0));
//        System.out.println(menuListByUserId);

        QueryWrapper<AdminMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", 0);

        wrapper.last(" and id in (select menu_id from role_menu where role_id = (select role_id from user_role where user_id=1))");

        List<AdminMenu> adminMenus = adminMenuMapper.selectList(wrapper);

        System.out.println(adminMenus);

    }
}
