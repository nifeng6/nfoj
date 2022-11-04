package com.jishu5.ctfcommunityserver.service.impl;

import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.mapper.UserMapper;
import com.jishu5.ctfcommunityserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-04 18:43:46
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
