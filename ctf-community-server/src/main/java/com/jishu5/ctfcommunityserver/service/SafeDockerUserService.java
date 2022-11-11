package com.jishu5.ctfcommunityserver.service;

import com.jishu5.ctfcommunityserver.dto.params.index.CloseLabParamsDto;
import com.jishu5.ctfcommunityserver.dto.params.index.LabDetailParamsDto;
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

    public R getDetailById(LabDetailParamsDto labDetailParamsDto);

    public R closeLab(CloseLabParamsDto closeLabParamsDto);

    public R closeLabByName(String dockerName);
}
