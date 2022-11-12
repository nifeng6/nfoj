package com.jishu5.ctfcommunityserver.config;

import com.jishu5.ctfcommunityserver.constant.FilePathConstant;
import com.jishu5.ctfcommunityserver.constant.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Value("${static.avatar}")
    private String avatarPath;

    // 本地资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(FilePathConstant.AVATAR_PATH + "**").addResourceLocations("file:" + avatarPath + "**");
    }


}
