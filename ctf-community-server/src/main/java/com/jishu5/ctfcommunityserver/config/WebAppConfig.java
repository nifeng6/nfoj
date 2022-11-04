package com.jishu5.ctfcommunityserver.config;

import com.jishu5.ctfcommunityserver.intercept.SysInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    /**
     * 跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST","HEAD","PUT","DELETE","OPTIONS")
                .maxAge(3600);
    }

    @Value("${file.upload.image}")
    private String uploadPath;

    @Value("${file.assets.image}")
    private String assetsPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println(uploadPath);
        registry.addResourceHandler("/upload/image/**")
                .addResourceLocations("file:" + uploadPath);
        registry.addResourceHandler("/static/image/**")
                .addResourceLocations("file:" + assetsPath);
    }

    @Bean
    public SysInterceptor sysInterceptor(){
        return new SysInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        String[] patttern = new String[]{"/upload/**","/self_sale_ad/**", "/footerGroup/**","/include/**","/index/**","/article/**","/site/**","/sort/**","/tools/**","/admin/user/login"};
        registry.addInterceptor(sysInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(patttern);
    }


}
