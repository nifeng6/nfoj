package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeDocker;
import com.jishu5.ctfcommunityserver.mapper.SafeDockerMapper;
import com.jishu5.ctfcommunityserver.service.SafeDockerService;
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
public class SafeDockerServiceImpl extends ServiceImpl<SafeDockerMapper, SafeDocker> implements SafeDockerService {

    @Autowired
    private SafeDockerMapper safeDockerMapper;

    // 后台部分

    @Override
    public R getList(Integer currentPage, Integer pageSize, String keywords, Integer type) {
        try {
            QueryWrapper<SafeDocker> wrapper = new QueryWrapper<>();
            Page<SafeDocker> page = new Page<>(currentPage, pageSize);


            Page<SafeDocker> labsPage = safeDockerMapper.selectPage(page, wrapper);


            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", labsPage.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(labsPage));
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R deleteById(Integer id) {
        try {
            QueryWrapper<SafeDocker> wrapper = new QueryWrapper<>();
            wrapper.eq("id", id);
            safeDockerMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

    @Override
    public R deleteListById(String ids) {
        try {
            QueryWrapper<SafeDocker> wrapper = new QueryWrapper<>();
            wrapper.in("id", ids.split(","));
            safeDockerMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

    @Override
    public R addSafeDocker(SafeDocker safeDocker) {
        try {
            safeDockerMapper.insert(safeDocker);
            return R.ok("规则添加成功");
        }catch (Exception e){
            return R.error("规则添加失败");
        }
    }

    @Override
    public R updateSafDocker(SafeDocker safeDocker) {
        try {
            safeDockerMapper.updateById(safeDocker);
            return R.ok("规则更新成功");
        }catch (Exception e){
            return R.error("规则更新失败");
        }
    }

    @Override
    public R getList() {
        try {
            QueryWrapper<SafeDocker> wrapper = new QueryWrapper<>();
            List<SafeDocker> safeDockerList = safeDockerMapper.selectList(wrapper);

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data",safeDockerList);
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

}
