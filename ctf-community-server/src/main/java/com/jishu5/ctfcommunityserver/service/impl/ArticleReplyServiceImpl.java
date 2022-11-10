package com.jishu5.ctfcommunityserver.service.impl;

import com.jishu5.ctfcommunityserver.dto.AddReplyDto;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.ArticleReply;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.mapper.ArticleReplyMapper;
import com.jishu5.ctfcommunityserver.service.ArticleReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
@Service
public class ArticleReplyServiceImpl extends ServiceImpl<ArticleReplyMapper, ArticleReply> implements ArticleReplyService {

    @Autowired
    private ArticleReplyMapper articleReplyMapper;

    @Override
    public R addReply(AddReplyDto addReplyDto) {
        try {
            LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            ArticleReply articleReply = new ArticleReply();
            articleReply.setUserId(loginUser.getUser().getId());
            articleReply.setContent(addReplyDto.getContent());
            articleReply.setCreateTime(new Date());
            articleReply.setReplyFatherId(addReplyDto.getReplyFatherId());
            articleReply.setArticleId(addReplyDto.getArticleId());
            if(addReplyDto.getType() == 1){
                articleReply.setReplyUserId(0);
                articleReply.setReplyId(0);
            }else if(addReplyDto.getType() == 2){
                articleReply.setReplyUserId(addReplyDto.getReplyUserId());
                articleReply.setReplyId(addReplyDto.getReplyId());
            }else{
                return R.error("回复失败");
            }
            if (articleReplyMapper.insert(articleReply) == 1){
                return R.ok("回复成功");

            }
            return R.error("回复失败");
        }catch (Exception e){
            return R.error();
        }
    }
}
