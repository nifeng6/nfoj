package com.jishu5.ctfcommunityserver.service;

import com.jishu5.ctfcommunityserver.dto.params.index.StartLabParamsDto;
import com.jishu5.ctfcommunityserver.dto.params.index.SubmitFlagParamsDto;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeLabs;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
public interface SafeLabsService extends IService<SafeLabs> {
    public R startLab(StartLabParamsDto startLabParamsDto);

    public R submitFlag(SubmitFlagParamsDto submitFlagParamsDto);
}
