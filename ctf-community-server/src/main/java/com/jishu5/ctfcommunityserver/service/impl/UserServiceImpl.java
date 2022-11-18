package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.constant.DefaultConstant;
import com.jishu5.ctfcommunityserver.constant.FilePathConstant;
import com.jishu5.ctfcommunityserver.dao.LoginService;
import com.jishu5.ctfcommunityserver.dto.LoginDto;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.dto.UpdatePassDto;
import com.jishu5.ctfcommunityserver.dto.params.index.ResetPasswordParams;
import com.jishu5.ctfcommunityserver.entity.*;
import com.jishu5.ctfcommunityserver.mapper.*;
import com.jishu5.ctfcommunityserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import com.jishu5.ctfcommunityserver.utils.JwtUtil;
import com.jishu5.ctfcommunityserver.utils.RedisCache;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

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

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private CoinRecordMapper coinRecordMapper;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RoleMapper roleMapper;

    @Value("${static-url}")
    private String staticURL;


    @Override
    public R getUserInfo(Integer user_id) {
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("id",user_id);
            User user = userMapper.selectOne(wrapper);

            Role role = roleMapper.getRoleByUserId(user_id);

            Map<String, Object> map = new HashMap<>();
            Map<String, Object> resultMap = new HashMap<>();

            map.put("id", user.getId());
            map.put("username", user.getUsername());
            map.put("createTime",user.getCreateTime());
            map.put("description",user.getDescription());
            map.put("nickName",user.getNickName());
            map.put("avatarUrl",user.getAvatarUrl());
            map.put("role", role);

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

    @Override
    public R updateInfo(User user) {
        try {
            LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(!loginUser.getUser().getId().equals(user.getId())){
                return R.error("异常修改，系统已记录您的IP地址！");
            }

            int updateById = userMapper.updateById(user);

            if(updateById == 1){
                loginUser.setUser(user);
                redisCache.setCacheObject("login:"+user.getId(), loginUser);//将用户信息直接存入redis
                return R.ok("更新成功");
            }
            return R.error("更新失败");
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R updatePassword(UpdatePassDto updatePassDto) {
        try {
            LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", loginUser.getUser().getId()));

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (!encoder.matches(updatePassDto.getOldPass(), user.getPassword())){
                return R.error("旧密码错误");
            }
            user.setPassword(JwtUtil.generalPass(updatePassDto.getNewPass()));
            if(userMapper.updateById(user) == 1){
                // 更新redis信息
                user.setPassword(encoder.encode(updatePassDto.getNewPass()));
                loginUser.setUser(user);
                redisCache.setCacheObject("login:"+user.getId(), loginUser);//将用户信息直接存入redis
                return R.ok("密码修改成功");
            }
            return R.error("密码修改失败");
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    @Transactional
    public R qiandao() {
        try {
            LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            // 判断用户当天是否签到
            Object time = redisCache.getCacheObject("user:qiandao" + loginUser.getUser().getId());
            Date currentDate = new Date();
            if(time == null){
                return qiandaoFn(loginUser);
            }else{
                Date redisDate = new Date(Long.parseLong(time.toString()));
                if (DateUtils.isSameDay(redisDate, currentDate)){
                    return R.error("今日已签到");
                }
                return qiandaoFn(loginUser);
            }
        }catch (Exception e){
            // 事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.error();
        }
    }

    @Override
    public R register(User user) {
        try {
            // 判断邮箱验证码是否正确
            String code = redisCache.getCacheObject("user:email:verify:" + user.getEmail());
            if(!user.getEmailCode().equals(code)){
                return R.error("邮箱验证码错误");
            }

            // 判断用户是否被注册过
            User confirmUser = userMapper.selectOne(new QueryWrapper<User>().eq("username",user.getUsername()));
            if(confirmUser != null){
                return R.error("用户名已被注册，请重新选择用户名！");
            }
            // 判断用户账号密码邮箱长度/格式等是否标准
            if(user.getUsername().length() > 15 || user.getUsername().length() < 2){
                return R.error("用户名应该在2~15位！");
            }
            if(user.getPassword().length() > 20 || user.getPassword().length() <6){
                return R.error("密码应该在6~20位！");
            }
            if (!user.getEmail().matches("^\\w+(\\w|[.]\\w+)+@\\w+([.]\\w+){1,3}")){
                return R.error("邮箱格式不正确！");
            }

            // 加密密码
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            user.setNickName(user.getUsername());
            user.setCreateTime(new Date());
            user.setAvatarUrl(staticURL + DefaultConstant.DEFAULT_AVATAR_PATH);
            user.setStatus(DefaultConstant.DEFAULT_USER_STATUS);
            user.setCoin(DefaultConstant.DEFAULT_USER_COIN);
            user.setDescription(DefaultConstant.DEFAULT_USER_DESCRIPTION);

            userMapper.insert(user);

            // 删除redis中的验证码
            redisCache.deleteObject("user:email:verify:" + user.getEmail());

            return R.ok("账号注册成功，请登录~");
        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.getMessage());
            return R.error();
        }
    }

    // 执行签到逻辑
    public R qiandaoFn(LoginUser loginUser){
        // 增加的金币
        Integer coin = 10;
        // 增加用户表金币
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", loginUser.getUser().getId()));
        Integer count = user.getCoin() + coin;
        user.setCoin(count);
        userMapper.updateById(user);
        // 增加金币记录
        CoinRecord coinRecord = new CoinRecord();
        coinRecord.setAmount(coin);
        coinRecord.setCount(count);
        coinRecord.setCreateTime(new Date());
        coinRecord.setUserId(user.getId());
        coinRecord.setRemark("网站签到");
        coinRecordMapper.insert(coinRecord);

        // redis增加当天签到记录
        redisCache.setCacheObject("user:qiandao"+user.getId(), new Date().getTime());

        return R.ok("签到成功");
    }

    public R resetPassword(ResetPasswordParams resetPasswordParams){
        try {
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("username",resetPasswordParams.getUsername()));
            if(user == null){
                return R.error("该用户不存在");
            }
            String code = redisCache.getCacheObject("user:email:reset:verify:" + user.getEmail());

            System.out.println(code);
            System.out.println(resetPasswordParams.getEmailCode());

            if(!resetPasswordParams.getEmailCode().equals(code)){
                return R.error("验证码错误");
            }
            // 加密密码并存入数据库
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(resetPasswordParams.getPassword()));
            userMapper.updateById(user);
            // 删除redis验证码，以免被重复利用
            redisCache.deleteObject("user:email:reset:verify:" + user.getEmail());
            return R.ok("重置成功");
        }catch (Exception e){
            return R.error("重置失败");
        }
    }

    // 后台部分

    @Override
    public R getList(Integer currentPage, Integer pageSize, String keywords, Integer type) {
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            Page<User> page = new Page<>(currentPage, pageSize);
            if(keywords != null){
                wrapper.like("title", keywords);
            }
            if(type != null){
                wrapper.eq("sort_id", type);
            }

            Page<User> userPage = userMapper.selectPage(page, wrapper);



            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", userPage.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(userPage));
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R deleteById(Integer id) {
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("id", id);
            userMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

    @Override
    public R deleteListById(String ids) {
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.in("id", ids.split(","));
            userMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

    @Override
    public R addUser(User user) {
        try {
            user.setCreateTime(new Date());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));

            userMapper.insert(user);
            return R.ok();
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R updateUser(User user) {
        try {
            userMapper.updateById(user);

            return R.ok("更新成功");
        }catch (Exception e){
            return R.error("更新失败");
        }
    }

}
