package com.jishu5.ctfcommunityserver;

import com.jishu5.ctfcommunityserver.utils.EmailUtil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CtfCommunityServerApplicationTests {

    @Autowired
    private EmailUtil emailUtil;

    @Test
    void test2(){
        emailUtil.sendMail("194908655@qq.com","测试邮件","这是一封<h1>王熙来</h1>的测试邮件");

    }

}
