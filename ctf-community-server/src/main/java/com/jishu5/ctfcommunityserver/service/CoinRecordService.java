package com.jishu5.ctfcommunityserver.service;

import com.jishu5.ctfcommunityserver.entity.CoinRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
public interface CoinRecordService extends IService<CoinRecord> {

    public R getList(Integer currentPage, Integer pageSize);

}
