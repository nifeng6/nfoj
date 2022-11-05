package com.jishu5.ctfcommunityserver.controller.index;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.PageDto;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.ToolHotTags;
import com.jishu5.ctfcommunityserver.entity.ToolList;
import com.jishu5.ctfcommunityserver.entity.ToolType;
import com.jishu5.ctfcommunityserver.service.impl.ToolHotTagsServiceImpl;
import com.jishu5.ctfcommunityserver.service.impl.ToolListServiceImpl;
import com.jishu5.ctfcommunityserver.service.impl.ToolTagsServiceImpl;
import com.jishu5.ctfcommunityserver.service.impl.ToolTypeServiceImpl;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index/tools")
public class IndexToolsController {

    @Autowired
    private ToolListServiceImpl toolListService;

    @Autowired
    private ToolHotTagsServiceImpl toolHotTagsService;

    @Autowired
    private ToolTagsServiceImpl toolTagsService;

    @Autowired
    private ToolTypeServiceImpl toolTypeService;

    @GetMapping("/tag/list")
    public R TagList(){
        try {
            List<ToolHotTags> toolHotTagsList = toolHotTagsService.list();

            Map<String,Object> resultMap = new HashMap<>();

            resultMap.put("data", toolHotTagsList);

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @GetMapping("/type/list")
    public R typeList(){
        try {
            List<ToolType> toolTypeList = toolTypeService.list();

            Map<String,Object> resultMap = new HashMap<>();

            resultMap.put("data", toolTypeList);

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @GetMapping("/list")
    public R list(Integer currentPage, Integer pageSize, Integer type,String keywords){
        try {
            QueryWrapper<ToolList> wrapper = new QueryWrapper<>();

            if(type != 0){
                wrapper.eq("type_id", type);
            }

            if(!keywords.equals("")){
                wrapper.like("title", keywords);
                wrapper.or();
                wrapper.like("intro", keywords);
                wrapper.or();
                wrapper.like("tags", keywords);
            }


            Page<ToolList> page = new Page<>(currentPage, pageSize);

            Page<ToolList> toolListPage = toolListService.page(page, wrapper);

            PageDto pageDto = DtoUtils.pageDtoHandle(toolListPage);

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data",toolListPage.getRecords());

            resultMap.put("page", pageDto);

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }


}
