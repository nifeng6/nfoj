package com.jishu5.ctfcommunityserver.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.dao.EmailService;
import com.jishu5.ctfcommunityserver.dto.params.index.EmailSendParams;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.mapper.UserMapper;
import com.jishu5.ctfcommunityserver.utils.EmailUtil;
import com.jishu5.ctfcommunityserver.utils.RedisCache;
import com.jishu5.ctfcommunityserver.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private UserMapper userMapper;

    @Value("${main-url}")
    private String mainURL;

    @Override
    public R registerEmail(EmailSendParams emailSendParams) {
        try {
            // 判断邮箱是否存在
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("email", emailSendParams.getEmail()));
            if (user != null){
                return R.error("该邮箱已被注册");
            }

            // 判断是验证码否存在
            Object emailTime = redisCache.getCacheObject("user:email:time:" + emailSendParams.getEmail());
            if(emailTime != null){
                return R.error("请勿频繁发送验证码，耐心等待120秒后重试...");
            }
            String code = StringUtil.getRandomString(5);

            String content = "请在5分钟内完成验证，验证码为：" + code;

            emailUtil.sendMail(emailSendParams.getEmail(),"NFOJ的注册通知",content);

            redisCache.setCacheObject("user:email:verify:"+emailSendParams.getEmail(), code,5, TimeUnit.MINUTES);
            redisCache.setCacheObject("user:email:time:"+emailSendParams.getEmail(), code,2, TimeUnit.MINUTES);
            return R.ok();
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R resetPasswordEmail(EmailSendParams emailSendParams) {
        try {
            // 判断邮箱是否存在
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("email", emailSendParams.getEmail()));
            if (user == null){
                return R.error("该邮箱还未注册");
            }

            // 判断是验证码否存在，存在代表频繁
            Object emailTime = redisCache.getCacheObject("user:email:time:" + emailSendParams.getEmail());
            if(emailTime != null){
                return R.error("请勿频繁发送验证码，耐心等待120秒后重试...");
            }
            // 生成15位随机字符，作为验证码
            String code = StringUtil.getRandomString(15);
            String url = mainURL + "/reset-password?username="+user.getUsername()+"&code="+code;
            String content = "请在5分钟内完成验证，验证码为：" + code + "点击链接快速重置：" + url;

            emailUtil.sendMail(emailSendParams.getEmail(),"NFOJ的注册通知",content);

            redisCache.setCacheObject("user:email:reset:verify:"+emailSendParams.getEmail(), code,5, TimeUnit.MINUTES);
            redisCache.setCacheObject("user:email:time:"+emailSendParams.getEmail(), code,2, TimeUnit.MINUTES);
            return R.ok();
        }catch (Exception e){
            return R.error();
        }
    }

}
