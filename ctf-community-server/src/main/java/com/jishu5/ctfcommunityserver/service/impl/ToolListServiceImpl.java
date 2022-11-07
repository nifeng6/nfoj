package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.PageDto;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.ToolHotTags;
import com.jishu5.ctfcommunityserver.entity.ToolList;
import com.jishu5.ctfcommunityserver.mapper.ToolListMapper;
import com.jishu5.ctfcommunityserver.service.ToolListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
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
public class ToolListServiceImpl extends ServiceImpl<ToolListMapper, ToolList> implements ToolListService {

    @Autowired
    private ToolListMapper toolListMapper;

    @Override
    public R getList(Integer currentPage, Integer pageSize, Integer type, String keywords) {
        try {
            QueryWrapper<ToolList> wrapper = new QueryWrapper<>();

            if (type != 0) {
                wrapper.eq("type_id", type);
            }

            if (!keywords.equals("")) {
                wrapper.and(childWrapper -> childWrapper.like("title", keywords)
                        .or().like("intro", keywords)
                        .or().like("tags", keywords));
            }


            Page<ToolList> page = new Page<>(currentPage, pageSize);

            Page<ToolList> toolListPage = toolListMapper.selectPage(page, wrapper);

            PageDto pageDto = DtoUtils.pageDtoHandle(toolListPage);

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", toolListPage.getRecords());

            resultMap.put("page", pageDto);

            return R.ok(resultMap);
        } catch (Exception e) {
            return R.error();
        }
    }
}
