package com.jishu5.ctfcommunityserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class CtfCommunityServerApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encode = encoder.encode("123456");
        System.out.println(encode);
        System.out.println(encoder.matches("123456", "$2a$10$UUrI9tONhIGtU9cFIWVr8ev6ZylO1Syy2b3eheLLr15Z043PvIFrq"));
    }

}
