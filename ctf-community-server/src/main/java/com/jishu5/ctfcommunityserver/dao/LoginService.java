package com.jishu5.ctfcommunityserver.dao;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;

public interface LoginService {

    public R login(User user);

    public R logout();

    public R getInfo();

}
