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

    public R getDetail(Integer id);

    public R getArticleListById(Integer currentPage, Integer pageSize, Integer id);

    public R addArticle(Article article);

    public R getReplyList(Integer currentPage, Integer pageSize, Integer id);

    public R getNoticeList(Integer currentPage, Integer pageSize);


    // 以下为后台部分
    public R getArticleList(Integer currentPage, Integer pageSize, String keywords, Integer type, String createTime);

    public R deleteArticleById(Integer id);

    public R deleteArticleListById(String ids);

    public R addArticle();

}
