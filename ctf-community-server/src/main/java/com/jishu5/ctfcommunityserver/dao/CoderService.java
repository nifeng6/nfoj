package com.jishu5.ctfcommunityserver.dao;

import com.jishu5.ctfcommunityserver.dto.CoderParamsDto;
import com.jishu5.ctfcommunityserver.dto.ShareCodeDto;
import com.jishu5.ctfcommunityserver.entity.R;
import org.springframework.web.bind.annotation.RequestBody;

public interface CoderService {

    public R run(CoderParamsDto coderParamsDto);

    public R shareCode(ShareCodeDto shareCodeDto);

    public R getShareCode(String key);

}
