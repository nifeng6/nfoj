package com.jishu5.ctfcommunityserver.dao.impl;

import com.alibaba.fastjson.JSON;
import com.jishu5.ctfcommunityserver.constant.SystemConstant;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(SystemConstant.JWT_ERRCODE_LOWPOWER);
        R result = R.error(SystemConstant.JWT_ERRCODE_LOWPOWER, "权限不足无法访问");
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
