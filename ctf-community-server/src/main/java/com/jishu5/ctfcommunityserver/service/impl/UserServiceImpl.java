package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.dto.LoginDto;
import com.jishu5.ctfcommunityserver.entity.*;
import com.jishu5.ctfcommunityserver.mapper.ArticleMapper;
import com.jishu5.ctfcommunityserver.mapper.SafeDockerMapper;
import com.jishu5.ctfcommunityserver.mapper.SafeDockerUserMapper;
import com.jishu5.ctfcommunityserver.mapper.UserMapper;
import com.jishu5.ctfcommunityserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private SafeDockerUserMapper safeDockerUserMapper;

    @Override
    public R getUserInfo(Integer user_id) {
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("id",user_id);
            User user = userMapper.selectOne(wrapper);

            Map<String, Object> map = new HashMap<>();
            Map<String, Object> resultMap = new HashMap<>();

            map.put("id", user.getId());
            map.put("username", user.getUsername());
            map.put("createTime",user.getCreateTime());

            resultMap.put("data", map);
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R getUserRecord(Integer user_id) {
        try {

            Integer articleCount = articleMapper.selectCount(new QueryWrapper<Article>().eq("user_id",user_id));
            Integer coinCount = userMapper.selectOne(new QueryWrapper<User>().eq("id",user_id)).getCoin();
            Integer safeRecordCount = safeDockerUserMapper.selectCount(new QueryWrapper<SafeDockerUser>().eq("user_id",user_id));
            Map<String, Object> map = new HashMap<>();
            map.put("articleCount", articleCount);
            map.put("safeRecordCount", safeRecordCount);
            map.put("coinCount", coinCount);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("data", map);
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }
}
