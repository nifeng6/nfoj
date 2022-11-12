package com.jishu5.ctfcommunityserver.controller.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.jishu5.ctfcommunityserver.dto.params.index.EmailSendParams;
import com.jishu5.ctfcommunityserver.dto.params.index.ResetPasswordVerityParams;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.mapper.UserMapper;
import com.jishu5.ctfcommunityserver.utils.EmailUtil;
import com.jishu5.ctfcommunityserver.utils.RedisCache;
import com.jishu5.ctfcommunityserver.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/common/util")
public class UtilController {

    @Resource
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private RedisCache redisCache;

    public String getCheckCode() {
        return CheckCode;
    }

    public void setCheckCode(String checkCode) {
        CheckCode = checkCode;
    }

    private String CheckCode;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private UserMapper userMapper;


    // 图片验证码
    @GetMapping("/captcha")
    public void defaultCaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaOutputStream = null;
        ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String verifyCode = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("verifyCode", verifyCode);

            this.setCheckCode(verifyCode);
            BufferedImage challenge = defaultKaptcha.createImage(verifyCode);
            ImageIO.write(challenge, "jpg", imgOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        captchaOutputStream = imgOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaOutputStream);
        responseOutputStream.flush();
        responseOutputStream.close();

    }

    // 找回密码验证码发送
    public R resetEmailSend(@RequestBody EmailSendParams emailSendParams){
        try {
            // 判断是否存在
            Object isNull = redisCache.getCacheObject("user:email:verify:" + emailSendParams.getEmail());
            if(isNull != null){
                return R.error("请勿频繁发送验证码，耐心等待5分钟后重试...");
            }
            String code = StringUtil.getRandomString(20);

            String content = "点击链接修改密码：" + code;

            emailUtil.sendMail(emailSendParams.getEmail(),"NFOJ的找回密码通知",content);

            redisCache.setCacheObject("user:email:verify:"+emailSendParams.getEmail(), code,5, TimeUnit.MINUTES);
            return R.ok();
        }catch (Exception e){
            return R.error();
        }
    }

    // 修改密码邮箱验证
    @PostMapping("/reset/password/email/verify")
    private R emailVerify(@RequestBody ResetPasswordVerityParams resetPasswordVerityParams){
        try {
            // 判断是否存在
            Object code = redisCache.getCacheObject("user:email:verify:" + resetPasswordVerityParams.getEmail());
            if(code == null){
                return R.error("验证码错误");
            }
            if(!resetPasswordVerityParams.getCode().equals(code.toString())){
                return R.error("验证码错误");
            }
            // 开始修改密码逻辑
            UpdateWrapper<User> wrapper = new UpdateWrapper<>();
            wrapper.eq("username", resetPasswordVerityParams.getUsername());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            wrapper.set("password",encoder.encode(resetPasswordVerityParams.getPassword()));
            User user = new User();
            user.setPassword(encoder.encode(resetPasswordVerityParams.getPassword()));
            user.setUsername(resetPasswordVerityParams.getUsername());
            userMapper.update(user, wrapper);

            return R.ok("密码修改成功");
        }catch (Exception e){
            return R.error("修改失败");
        }
    }

}
