package com.jishu5.ctfcommunityserver.dao.impl;

import com.alibaba.fastjson.JSON;
import com.jishu5.ctfcommunityserver.constant.SystemConstant;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setStatus(SystemConstant.JWT_ERRCODE_FAIL);//4002 表示没有授权
        R result = R.error(SystemConstant.JWT_ERRCODE_FAIL, "认证失败");
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
