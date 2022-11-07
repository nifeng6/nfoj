package com.jishu5.ctfcommunityserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jishu5.ctfcommunityserver.entity.R;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
public interface ArticleService extends IService<Article> {
    public R getArticleList(Integer currentPage, Integer pageSize, String keywords, Integer type);

}
