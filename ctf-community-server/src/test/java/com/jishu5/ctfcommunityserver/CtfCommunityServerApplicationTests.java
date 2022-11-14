package com.jishu5.ctfcommunityserver;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.entity.SafeLabsRecord;
import com.jishu5.ctfcommunityserver.service.SafeLabsRecordService;
import com.jishu5.ctfcommunityserver.utils.EmailUtil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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

}
