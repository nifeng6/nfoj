package com.jishu5.ctfcommunityserver.exception;

import com.jishu5.ctfcommunityserver.entity.R;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = AccessDeniedException.class)
    public R handleAccessRE(AccessDeniedException e) {
        return R.error("当前用户权限不足！");
    }

    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(HttpServletRequest request,Exception e){
        return R.error(e.getMessage());
    }
}
