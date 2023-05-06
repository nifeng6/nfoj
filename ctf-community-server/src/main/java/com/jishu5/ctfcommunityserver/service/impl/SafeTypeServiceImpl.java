package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeType;
import com.jishu5.ctfcommunityserver.mapper.SafeTypeMapper;
import com.jishu5.ctfcommunityserver.service.SafeTypeService;
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
public class SafeTypeServiceImpl extends ServiceImpl<SafeTypeMapper, SafeType> implements SafeTypeService {

    @Autowired
    private SafeTypeMapper safeTypeMapper;

    @Override
    public R getList() {
        try {
            QueryWrapper<SafeType> wrapper = new QueryWrapper<>();
            List<SafeType> safeTypeList = safeTypeMapper.selectList(wrapper);
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("data",safeTypeList);
            return R.ok(resultMap);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return R.error();
        }
    }
}
