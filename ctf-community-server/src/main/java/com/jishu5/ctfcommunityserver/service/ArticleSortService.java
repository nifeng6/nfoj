package com.jishu5.ctfcommunityserver.service;

import com.jishu5.ctfcommunityserver.entity.ArticleSort;
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
public interface ArticleSortService extends IService<ArticleSort> {

    public R getArticleTypeList();

}
