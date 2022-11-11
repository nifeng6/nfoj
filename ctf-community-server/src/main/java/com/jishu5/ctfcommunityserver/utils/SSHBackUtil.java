package com.jishu5.ctfcommunityserver.utils;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class SSHBackUtil {

    @Value("${ctf.server}")
    private String server;

    @Value("${ctf.user}")
    private String user;

    @Value("${ctf.password}")
    private String password;

    public String sendCommand(String command){
        String USER = user;
        String PASSWORD = password;
        String HOST = server;

        int DEFAULT_SSH_PORT=22;
        JSch jsch = new JSch();
        try {
            Session session = jsch.getSession(USER, HOST, DEFAULT_SSH_PORT);

            session.setConfig("StrictHostKeyChecking", "no");

            session.setPassword(PASSWORD);

            session.connect();

            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");

            InputStream in = channelExec.getInputStream();

            channelExec.setCommand(command);

            channelExec.setErrStream(System.err);

            channelExec.connect();

            String errOut = IOUtils.toString(channelExec.getErrStream(), "UTF-8");

            String out = IOUtils.toString(in, "UTF-8");

            channelExec.disconnect();

            session.disconnect();
            return out;
        }catch (Exception e){
            return "获取失败";
        }

    }

}
