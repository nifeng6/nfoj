package com.jishu5.ctfcommunityserver.task;

import com.jishu5.ctfcommunityserver.dto.params.index.CloseLabParamsDto;
import com.jishu5.ctfcommunityserver.service.SafeDockerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class RedisKeyExpiration extends KeyExpirationEventMessageListener {

    private static SafeDockerUserService safeDockerUserService; // 使用方法在这里完成注入
    @Autowired
    public void setRedisService (SafeDockerUserService safeDockerUserService){
        RedisKeyExpiration.safeDockerUserService= safeDockerUserService;
    }

    public RedisKeyExpiration(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    // 这是继承KeyExpirationEventMessageListener 主动重写的方法，用于处理当监听到了Key失效的时间
    @Override
    public void onMessage(Message message, byte[] pattern) {
        super.onMessage(message, pattern);
        if (message.toString().startsWith("codetip:safe:labs:")){
            // 获取并关闭靶场
            String dockerName = message.toString().split("codetip:safe:labs:")[1];
            safeDockerUserService.closeLabByName(dockerName);
        }



    }



}