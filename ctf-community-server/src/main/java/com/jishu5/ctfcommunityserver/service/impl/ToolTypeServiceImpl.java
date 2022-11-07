package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.ToolType;
import com.jishu5.ctfcommunityserver.mapper.ToolTypeMapper;
import com.jishu5.ctfcommunityserver.service.ToolTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ToolTypeServiceImpl extends ServiceImpl<ToolTypeMapper, ToolType> implements ToolTypeService {

    @Autowired
    private ToolTypeMapper toolTypeMapper;

    @Override
    public R getList() {
        try {
            QueryWrapper<ToolType> wrapper = new QueryWrapper<>();

            List<ToolType> toolTypeList = toolTypeMapper.selectList(wrapper);

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", toolTypeList);

            return R.ok(resultMap);
        } catch (Exception e) {
            return R.error();
        }
    }
}
