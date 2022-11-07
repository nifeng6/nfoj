package com.jishu5.ctfcommunityserver.controller.index;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.PageDto;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.ToolHotTags;
import com.jishu5.ctfcommunityserver.entity.ToolList;
import com.jishu5.ctfcommunityserver.entity.ToolType;
import com.jishu5.ctfcommunityserver.service.ToolListService;
import com.jishu5.ctfcommunityserver.service.ToolTagsService;
import com.jishu5.ctfcommunityserver.service.ToolTypeService;
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
    private ToolListService toolListService;

    @Autowired
    private ToolHotTagsServiceImpl toolHotTagsService;

    @Autowired
    private ToolTagsService toolTagsService;

    @Autowired
    private ToolTypeService toolTypeService;

    @GetMapping("/tag/list")
    public R TagList() {
        return toolTagsService.getList();
    }

    @GetMapping("/type/list")
    public R typeList() {
        return toolTypeService.getList();
    }

    @GetMapping("/list")
    public R list(Integer currentPage, Integer pageSize, Integer type, String keywords) {
        return toolListService.getList(currentPage, pageSize, type, keywords);
    }


}
