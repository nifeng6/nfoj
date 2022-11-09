package com.jishu5.ctfcommunityserver.service;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeDockerUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
public interface SafeDockerUserService extends IService<SafeDockerUser> {

    public R getListById(Integer currentPage, Integer pageSize, Integer id);

}
