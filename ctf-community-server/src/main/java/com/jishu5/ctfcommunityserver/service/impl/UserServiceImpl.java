package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.dto.LoginDto;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.mapper.UserMapper;
import com.jishu5.ctfcommunityserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public R login(LoginDto loginDto) {
        return null;
    }

//    @Override
//    public R login(LoginDto loginDto) {
//        try {
//            User resultUser = userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
//            if(resultUser == null){
//                return R.error("用户不存在");
//            }
//            if(!resultUser.getPassword().equals(user.getPassword())){
//                return R.error("密码错误");
//            }
//            String token = JwtUtils.createJWT(resultUser.getIsAdmin().toString(), user.getUsername(), SystemConstant.JWT_TTL);
//            resultUser.setToken(token);
//            userService.updateById(resultUser);
//            Map<String,Object> resultMap = new HashMap<>();
//            resultMap.put("token",token);
//            resultMap.put("data",resultUser);
//
//        }catch (Exception e){
//            return R.error();
//        }
//    }
}
