package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.CoinRecord;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.mapper.CoinRecordMapper;
import com.jishu5.ctfcommunityserver.service.CoinRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
public class CoinRecordServiceImpl extends ServiceImpl<CoinRecordMapper, CoinRecord> implements CoinRecordService {

    @Autowired
    private CoinRecordMapper coinRecordMapper;

    @Override
    public R getList(Integer currentPage, Integer pageSize) {
        try {
            LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Page<CoinRecord> page = new Page<>(currentPage, pageSize);

            QueryWrapper<CoinRecord> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", loginUser.getUser().getId());

            Page<CoinRecord> pageResult = coinRecordMapper.selectPage(page, wrapper);

            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("data", pageResult.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(page));
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }
}
