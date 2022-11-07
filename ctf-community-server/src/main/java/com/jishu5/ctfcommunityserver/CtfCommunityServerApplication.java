package com.jishu5.ctfcommunityserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com/jishu5/ctfcommunityserver/mapper")
public class CtfCommunityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtfCommunityServerApplication.class, args);
    }

}
