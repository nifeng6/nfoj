package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.PageDto;
import com.jishu5.ctfcommunityserver.entity.*;
import com.jishu5.ctfcommunityserver.mapper.ToolListMapper;
import com.jishu5.ctfcommunityserver.mapper.ToolTypeMapper;
import com.jishu5.ctfcommunityserver.service.ToolListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private ToolTypeMapper toolTypeMapper;

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

    // 后台部分

    @Override
    public R getList(Integer currentPage, Integer pageSize, String keywords, Integer type) {
        try {
            QueryWrapper<ToolList> wrapper = new QueryWrapper<>();
            Page<ToolList> page = new Page<>(currentPage, pageSize);
            if(keywords != null){
                wrapper.like("title", keywords);
            }
            if(type != null){
                wrapper.eq("sort_id", type);
            }

            Page<ToolList> toolPage = toolListMapper.selectPage(page, wrapper);

            for (ToolList toolList : toolPage.getRecords()){
                ToolType toolType = toolTypeMapper.selectOne(new QueryWrapper<ToolType>().eq("id", toolList.getTypeId()));
                toolList.setType(toolType);
            }

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", toolPage.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(toolPage));
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R deleteById(Integer id) {
        try {
            QueryWrapper<ToolList> wrapper = new QueryWrapper<>();
            wrapper.eq("id", id);
            toolListMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

    @Override
    public R deleteListById(String ids) {
        try {
            QueryWrapper<ToolList> wrapper = new QueryWrapper<>();
            wrapper.in("id", ids.split(","));
            toolListMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

    @Override
    public R addTools(ToolList toolList) {
        try {
            toolList.setCreateTime(new Date());
            toolListMapper.insert(toolList);
            return R.ok("添加成功");
        }catch (Exception e){
            return R.error("工具添加失败");
        }
    }

    @Override
    public R updateTools(ToolList toolList) {
        try {
            toolListMapper.updateById(toolList);
            return R.ok("更新成功");
        }catch (Exception e){
            return R.error("更新失败");
        }
    }

}
