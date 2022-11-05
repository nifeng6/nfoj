package com.jishu5.ctfcommunityserver.controller.index;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.PageDto;
import com.jishu5.ctfcommunityserver.entity.*;
import com.jishu5.ctfcommunityserver.service.impl.SafeDockerUserServiceImpl;
import com.jishu5.ctfcommunityserver.service.impl.SafeLabsServiceImpl;
import com.jishu5.ctfcommunityserver.service.impl.SafeTagsServiceImpl;
import com.jishu5.ctfcommunityserver.service.impl.SafeTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.RectangularShape;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index/ctf")
public class IndexCtfController {

    @Autowired
    private SafeTypeServiceImpl safeTypeService;

    @Autowired
    private SafeTagsServiceImpl safeTagsService;

    @Autowired
    private SafeLabsServiceImpl safeLabsService;

    @Autowired
    private SafeDockerUserServiceImpl safeDockerUserService;


    @RequestMapping("/type/list")
    public R TypeList(){
        try {
            List<SafeType> safeTypeList = safeTypeService.list();
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("data",safeTypeList);
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @RequestMapping("/tag/list")
    public R TagList(){
        try {
            List<SafeTags> tagsList = safeTagsService.list();

            Map<String,Object> resultMap = new HashMap<>();

            resultMap.put("data",tagsList);

            return R.ok(resultMap);

        }catch (Exception e){
            return R.error();
        }
    }

    @GetMapping("/list")
    public R list(Integer currentPage, Integer pageSize,Integer type, String keywords){
        try {
            QueryWrapper<SafeLabs> wrapper = new QueryWrapper<>();

            if(type != 0){
                wrapper.eq("type_id", type);
            }

            if(!keywords.equals("")){
                wrapper.like("title", keywords);
            }

            Page<SafeLabs> page = new Page<>(currentPage, pageSize);

            Page<SafeLabs> safeLabsPage = safeLabsService.page(page, wrapper);

            for(SafeLabs safeLabs : safeLabsPage.getRecords()){
                int labCount = safeDockerUserService.count(new QueryWrapper<SafeDockerUser>().eq("lab_id", safeLabs.getId()));
                int successCount = safeDockerUserService.count(new QueryWrapper<SafeDockerUser>().eq("lab_id", safeLabs.getId()).eq("is_success",1));
                safeLabs.setCount(labCount);
                safeLabs.setSuccessCount(successCount);
            }

            Map<String,Object> resultMap = new HashMap<>();

            // 定义页面数据
            PageDto pageDto = new PageDto();
            pageDto.setTotal(safeLabsPage.getTotal());
            pageDto.setPages(safeLabsPage.getPages());
            pageDto.setPageSize(pageSize);
            pageDto.setCurrentPage(currentPage);

            resultMap.put("data",safeLabsPage.getRecords());
            resultMap.put("page",pageDto);

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }



}
