package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.entity.ArticleType;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.mapper.ArticleTypeMapper;
import com.jishu5.ctfcommunityserver.service.ArticleTypeService;
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
public class ArticleTypeServiceImpl extends ServiceImpl<ArticleTypeMapper, ArticleType> implements ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public R getArticleTypeList() {
        try {
            QueryWrapper<ArticleType> wrapper = new QueryWrapper<>();
            List<ArticleType> articleTypeList = articleTypeMapper.selectList(wrapper);

            Map<String,Object> resultMap = new HashMap<>();

            resultMap.put("data", articleTypeList);

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }
}
