package com.jishu5.ctfcommunityserver.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.dao.CoderService;
import com.jishu5.ctfcommunityserver.dto.CoderParamsDto;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.dto.ShareCodeDto;
import com.jishu5.ctfcommunityserver.entity.CodeShare;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.mapper.CodeShareMapper;
import com.jishu5.ctfcommunityserver.utils.QRCodeUtil;
import com.jishu5.ctfcommunityserver.utils.StringUtil;
import io.lettuce.core.cluster.event.RedirectionEventSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class CoderServiceImpl implements CoderService {

    @Autowired
    private CodeShareMapper codeShareMapper;

    @Value("${coder.server}")
    private String coderServer;

    @Value("${coder.port}")
    private Integer coderPort;

    @Value("${main-url}")
    private String mainURL;

    @Value("${coder.share-address}")
    private String shareAddress;


    @Override
    public R run(CoderParamsDto coderParamsDto) {
        Socket socket = new Socket();
        try {
            socket = new Socket(coderServer, coderPort);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            // 对接收到的内容进行编码，然后发送到服务器端
            outputStream.write(Base64.getEncoder().encodeToString(JSONObject.toJSON(coderParamsDto).toString().getBytes()).getBytes());
            int len = inputStream.read(bytes);
            String str = new String(bytes,0,len);

            // base64解密后的内容
            String decodeStr = new String(Base64.getDecoder().decode(str));
            // 解密后把数据转为json传给前台
            JSONObject runResult = JSON.parseObject(decodeStr);
            Map<String, Object> resultMap = new HashMap<>();
            Map<String, Object> map = new HashMap<>();
            map.put("content", runResult.get("data"));
            map.put("runTime", runResult.get("run_time"));
            map.put("code", runResult.get("run_code"));
            resultMap.put("data", map);
            socket.close();
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    public R shareCode(ShareCodeDto shareCodeDto){
        try {
            LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            // 生成唯一的键值，用来比对分享代码
            String key = StringUtil.getUUID();

            CodeShare codeShare = new CodeShare();
            codeShare.setContent(shareCodeDto.getContent());
            codeShare.setOnlyKey(key);
            codeShare.setType(shareCodeDto.getType());
            codeShare.setUserId(loginUser.getUser().getId());
            if (codeShareMapper.insert(codeShare) == 1){
                // 生成二维码
                String url = mainURL + shareAddress + key;
                String base64QRCode = QRCodeUtil.getBase64QRCode(url);
                Map<String,Object> resultMap = new HashMap<>();
                Map<String,Object> map = new HashMap<>();
                map.put("qrcode", base64QRCode);
                map.put("key", key);
                resultMap.put("data", map);
                return R.ok(resultMap);
            }
            return R.ok();
        }catch (Exception e){
            return R.error();
        }
    }

    public R getShareCode(String key){
        try {
            System.out.println(key);
            QueryWrapper<CodeShare> wrapper = new QueryWrapper<>();
            wrapper.eq("only_key",key);
            CodeShare codeShare = codeShareMapper.selectOne(wrapper);
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("data", codeShare);
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

}
