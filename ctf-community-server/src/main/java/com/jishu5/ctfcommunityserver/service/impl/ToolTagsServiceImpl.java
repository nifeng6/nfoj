package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.ToolHotTags;
import com.jishu5.ctfcommunityserver.entity.ToolTags;
import com.jishu5.ctfcommunityserver.mapper.ToolTagsMapper;
import com.jishu5.ctfcommunityserver.service.ToolTagsService;
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
public class ToolTagsServiceImpl extends ServiceImpl<ToolTagsMapper, ToolTags> implements ToolTagsService {

    @Autowired
    private ToolTagsMapper toolTagsMapper;

    @Override
    public R getList() {
        try {
            QueryWrapper<ToolTags> wrapper = new QueryWrapper<>();
            List<ToolTags> toolTags = toolTagsMapper.selectList(wrapper);

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", toolTags);

            return R.ok(resultMap);
        } catch (Exception e) {
            return R.error();
        }
    }
}
