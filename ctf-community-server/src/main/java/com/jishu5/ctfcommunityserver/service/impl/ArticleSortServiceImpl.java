package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jishu5.ctfcommunityserver.entity.ArticleSort;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.mapper.ArticleSortMapper;
import com.jishu5.ctfcommunityserver.service.ArticleSortService;
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
public class ArticleSortServiceImpl extends ServiceImpl<ArticleSortMapper, ArticleSort> implements ArticleSortService {

    @Autowired
    private ArticleSortMapper articleSortMapper;

    @Override
    public R getArticleTypeList() {
        try {
            QueryWrapper<ArticleSort> wrapper = new QueryWrapper<>();
            List<ArticleSort> articleSortList = articleSortMapper.selectList(wrapper);

            Map<String,Object> resultMap = new HashMap<>();

            resultMap.put("data", articleSortList);

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }
}
