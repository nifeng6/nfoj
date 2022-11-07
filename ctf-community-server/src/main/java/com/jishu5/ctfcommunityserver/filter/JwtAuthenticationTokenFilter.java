package com.jishu5.ctfcommunityserver.filter;


import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.utils.JwtUtil;
import com.jishu5.ctfcommunityserver.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //我们先拿到请求头中的token
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            //说明没有携带token 那么直接放行 之后的过滤器肯定会报错，那么就说明用户没有登录
            filterChain.doFilter(request,response);
            return;
        }
        //解析token
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid  = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            //就说明token失效了 或者是token无效
            throw new RuntimeException("token无效");
        }
        //从redis中拿到用户的信息，给SecurityContextHolder设置上下文
        LoginUser loginUser = (LoginUser)redisCache.getCacheObject("login:" + userid);
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }
        //存入SecurityContextHolder上下文当中  注意 这里必须得使用三个参数的authentication
        //第三个参数则为权限

        Authentication authentication = new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //放行
        filterChain.doFilter(request,response); //那么就正常的请求接口去啦！！！
    }
}
