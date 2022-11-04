package com.jishu5.ctfcommunityserver.intercept;

import com.jishu5.ctfcommunityserver.entity.CheckResult;
import com.jishu5.ctfcommunityserver.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.jishu5.ctfcommunityserver.constant.SystemConstant.JWT_ERRCODE_NOADMIN;


public class SysInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String path = request.getRequestURI();
        System.out.println("path: "+path);

        if(handler instanceof HandlerMethod){
            String token = request.getHeader("Authorization");

            CheckResult checkResult = JwtUtils.validateJWT(token);
            // token鉴权成功（非失效情况）进行二次校验
            if(checkResult.getSuccess()){
                Claims claims = JwtUtils.validateJWT(token).getClaims();
                // 管理员鉴权
                if(path.startsWith("/admin")){
                    if(!claims.getId().equals("1")){
                        throw new RuntimeException(String.valueOf(JWT_ERRCODE_NOADMIN));
                    }
                }
                return true;
            }else{
                throw new RuntimeException(String.valueOf(checkResult.getErrCode()));
            }



        }else{
            return true;
        }

    }

}
