package com.jishu5.ctfcommunityserver.filter;


import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.utils.JwtUtil;
import com.jishu5.ctfcommunityserver.utils.RedisCache;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

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


    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //我们先拿到请求头中的token
        String token = request.getHeader("Authorization");
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
        }catch (MalformedJwtException e){
            resolver.resolveException(request, response, null, new RuntimeException("用户认证格式不正确，请重新登录。"));
            return;
        }catch (SignatureException e){
            resolver.resolveException(request, response, null, new RuntimeException("签名认证错误，请重新登录。"));
            return;
        }catch (ExpiredJwtException e){
            resolver.resolveException(request, response, null, new RuntimeException("无效的会话，或者会话已过期，请重新登录。"));
            return;
        }catch (UnsupportedJwtException e){
            resolver.resolveException(request, response, null, new RuntimeException("禁止访问！"));
            return;
        }catch (Exception e) {
//            e.printStackTrace();
            resolver.resolveException(request, response, null, new RuntimeException("用户会话异常，请重新登录，或联系管理员。"));
            return;
//            throw new RuntimeException("token无效");
        }
        //从redis中拿到用户的信息，给SecurityContextHolder设置上下文
        LoginUser loginUser = (LoginUser)redisCache.getCacheObject("login:" + userid);
        if(Objects.isNull(loginUser)){
//            filterChain.doFilter(request,response);
            resolver.resolveException(request, response, null, new RuntimeException("用户未登录，请登录后重试。"));
            return;

//            throw new RuntimeException("用户未登录");
        }

        //存入SecurityContextHolder上下文当中  注意 这里必须得使用三个参数的authentication
        //第三个参数则为权限
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        //放行
        filterChain.doFilter(request,response); //那么就正常的请求接口去啦！！！
    }



}
