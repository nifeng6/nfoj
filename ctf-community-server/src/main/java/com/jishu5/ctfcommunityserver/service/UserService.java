package com.jishu5.ctfcommunityserver.service;

import com.jishu5.ctfcommunityserver.dto.LoginDto;
import com.jishu5.ctfcommunityserver.dto.UpdatePassDto;
import com.jishu5.ctfcommunityserver.dto.params.index.ResetPasswordParams;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
public interface UserService extends IService<User> {

    public R getUserInfo(Integer user_id);

    public R getUserRecord(Integer user_id);

    public R updateInfo(User user);

    public R updatePassword(UpdatePassDto updatePassDto);

    public R qiandao();

    public R register(User user);

    public R resetPassword(ResetPasswordParams resetPasswordParams);

    // 后台部分
    public R getList(Integer currentPage, Integer pageSize, String keywords, Integer type);

    public R deleteById(Integer id);

    public R deleteListById(String ids);

    public R addUser(User user);

    public R updateUser(User user);

}
