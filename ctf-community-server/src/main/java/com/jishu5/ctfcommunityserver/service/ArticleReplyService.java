package com.jishu5.ctfcommunityserver.service;

import com.jishu5.ctfcommunityserver.dto.AddReplyDto;
import com.jishu5.ctfcommunityserver.entity.ArticleReply;
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
public interface ArticleReplyService extends IService<ArticleReply> {

    public R addReply(AddReplyDto addReplyDto);


    // 以下为后台部分

    public R getReplyList(Integer currentPage, Integer pageSize, String keywords, Integer type);

    public R deleteReplyById(Integer id);

    public R deleteReplyListById(String ids);

    public R updateReplyById(ArticleReply articleReply);

}
