package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.AddReplyDto;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.*;
import com.jishu5.ctfcommunityserver.mapper.ArticleMapper;
import com.jishu5.ctfcommunityserver.mapper.ArticleReplyMapper;
import com.jishu5.ctfcommunityserver.mapper.UserMapper;
import com.jishu5.ctfcommunityserver.service.ArticleReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
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
public class ArticleReplyServiceImpl extends ServiceImpl<ArticleReplyMapper, ArticleReply> implements ArticleReplyService {

    @Autowired
    private ArticleReplyMapper articleReplyMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;

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

    // 以下为后台部分

    @Override
    public R getReplyList(Integer currentPage, Integer pageSize, String keywords, Integer type) {
        try {
            QueryWrapper<ArticleReply> wrapper = new QueryWrapper<>();
            Page<ArticleReply> page = new Page<>(currentPage, pageSize);
            if(keywords != null){
                wrapper.like("title", keywords);
            }
            if(type != null){
                wrapper.eq("sort_id", type);
            }

            Page<ArticleReply> articlePage = articleReplyMapper.selectPage(page, wrapper);

            for(ArticleReply articleReply : articlePage.getRecords()){
                User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", articleReply.getUserId()));
                Article article = articleMapper.selectOne(new QueryWrapper<Article>().eq("id", articleReply.getArticleId()));
                articleReply.setUser(user);
                articleReply.setArticle(article);
            }

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", articlePage.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(articlePage));
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R deleteReplyById(Integer id) {
        try {
            QueryWrapper<ArticleReply> wrapper = new QueryWrapper<>();
            wrapper.eq("id", id);
            articleReplyMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

    @Override
    public R deleteReplyListById(String ids) {
        try {
            QueryWrapper<ArticleReply> wrapper = new QueryWrapper<>();
            wrapper.in("id", ids.split(","));
            articleReplyMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }
}
