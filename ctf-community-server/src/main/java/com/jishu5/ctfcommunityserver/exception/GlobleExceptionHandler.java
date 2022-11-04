package com.jishu5.ctfcommunityserver.exception;

import com.jishu5.ctfcommunityserver.entity.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.jishu5.ctfcommunityserver.constant.SystemConstant.*;


@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(HttpServletRequest request, Exception e){


        if(e.getMessage().equals(String.valueOf(JWT_ERRCODE_NOADMIN))){
            return R.error(JWT_ERRCODE_NOADMIN,"非法请求");
        }else if(e.getMessage().equals(String.valueOf(JWT_ERRCODE_EXPIRE))){
            return R.error(JWT_ERRCODE_EXPIRE,"登录状态已过期，您可以继续留在该页面，或者重新登录");
        }else if(e.getMessage().equals(String.valueOf(JWT_ERRCODE_FAIL))){
            return R.error(JWT_ERRCODE_FAIL,"登录状态已失效，您可以继续留在该页面，或者重新登录");
        }else if(e.getMessage().equals(String.valueOf(JWT_ERRCODE_NULL))){
            return R.error(JWT_ERRCODE_NULL,"用户未登录，您可以继续留在该页面，或者重新登录");
        }

        return R.error("服务端异常，请联系管理员"+"\n"+e.getMessage());
    }
}
