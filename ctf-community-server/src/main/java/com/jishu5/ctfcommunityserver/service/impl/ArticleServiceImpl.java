package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.LoginUser;
import com.jishu5.ctfcommunityserver.entity.*;
import com.jishu5.ctfcommunityserver.mapper.ArticleMapper;
import com.jishu5.ctfcommunityserver.mapper.ArticleReplyMapper;
import com.jishu5.ctfcommunityserver.mapper.ArticleSortMapper;
import com.jishu5.ctfcommunityserver.mapper.UserMapper;
import com.jishu5.ctfcommunityserver.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import io.lettuce.core.cluster.event.RedirectionEventSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Date;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleSortMapper articleSortMapper;

    @Autowired
    private ArticleReplyMapper articleReplyMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public R getArticleList(Integer currentPage, Integer pageSize, String keywords, Integer type) {
        try {
            Page<Article> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Article> wrapper = new QueryWrapper<>();
            wrapper.orderByDesc("id");
            if (type != 0) {
                wrapper.eq("sort_id", type);
            }
            if (!keywords.equals("")) {
                wrapper.and(childWrapper -> childWrapper.like("title", keywords));
            }

            Page<Article> pageResult = articleMapper.selectPage(page, wrapper);

            for (Article article : pageResult.getRecords()){
                ArticleSort articleSort = articleSortMapper.selectOne(new QueryWrapper<ArticleSort>().eq("id", article.getSortId()));
                Integer replyCount = articleReplyMapper.selectCount(new QueryWrapper<ArticleReply>().eq("article_id", article.getId()));
                User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", article.getUserId()));

                article.setTypeName(articleSort.getName());

                article.setReplyCount(replyCount);

                article.setUser(user);

            }

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", pageResult.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(pageResult));

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    public R getDetail(Integer id){
        try {
            QueryWrapper<Article> wrapper = new QueryWrapper<>();
            wrapper.eq("id",id);
            Article article = articleMapper.selectOne(wrapper);
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("id",article.getUserId()));
            article.setUser(user);
            ArticleSort articleSort = articleSortMapper.selectOne(new QueryWrapper<ArticleSort>().eq("id",article.getSortId()));
            article.setSort(articleSort);
            article.setView(article.getView()+1);
            articleMapper.updateById(article);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("data",article);
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R getArticleListById(Integer currentPage, Integer pageSize, Integer userId) {
        try {
            Page<Article> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Article> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", userId);
            Page<Article> pageResult = articleMapper.selectPage(page, wrapper);

            for (Article article : pageResult.getRecords()){
                ArticleSort sort = articleSortMapper.selectOne(new QueryWrapper<ArticleSort>().eq("id", article.getSortId()));
                article.setSort(sort);
            }

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("page", DtoUtils.pageDtoHandle(pageResult));
            resultMap.put("data", pageResult.getRecords());
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R addArticle(Article article) {
        try {
            LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            article.setUserId(loginUser.getUser().getId());
            // 这里之后因该需要判断一下类型id，以免部分用户上传到公告
            article.setCreateTime(new Date());
            article.setUpdateTime(new Date());
            article.setId(null);

            articleMapper.insert(article);
            return R.ok("发布成功");
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R getReplyList(Integer currentPage, Integer pageSize, Integer id) {
        try {
            Page<ArticleReply> page = new Page<>(currentPage, pageSize);
            QueryWrapper<ArticleReply> wrapper = new QueryWrapper<>();
            wrapper.eq("article_id", id);
            wrapper.eq("reply_father_id", 0);
            wrapper.orderByDesc("id");
            Page<ArticleReply> pageResult = articleReplyMapper.selectPage(page, wrapper);
            for (ArticleReply articleReply : pageResult.getRecords()){
                User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", articleReply.getUserId()));
                List<ArticleReply> replyList = articleReplyMapper.selectList(new QueryWrapper<ArticleReply>().eq("reply_father_id", articleReply.getId()));
                // 遍历获取子评论的用户
                for (ArticleReply articleReplyChild : replyList){
                    User childUser = userMapper.selectOne(new QueryWrapper<User>().eq("id", articleReplyChild.getUserId()));
                    User childReplyUser = userMapper.selectOne(new QueryWrapper<User>().eq("id", articleReplyChild.getReplyUserId()));
                    articleReplyChild.setReplyUser(childReplyUser);
                    articleReplyChild.setUser(childUser);
                }

                articleReply.setReplyList(replyList);
                articleReply.setUser(user);
            }

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", pageResult.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(pageResult));

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R getNoticeList(Integer currentPage, Integer pageSize) {
        try {
            Page<Article> page = new Page<>(currentPage, pageSize);

            QueryWrapper<Article> wrapper = new QueryWrapper<>();
            wrapper.eq("sort_id", 4);
            Page<Article> articlePage = articleMapper.selectPage(page, wrapper);
            Map<String, Object> resultMap = new HashMap<>();

            for (Article article : articlePage.getRecords()){
                User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", article.getUserId()));
                article.setUser(user);

            }

            resultMap.put("data", articlePage.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(articlePage));

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    // 以下为后台部分

    @Override
    public R getArticleList(Integer currentPage, Integer pageSize, String keywords, Integer type, String createTime) {
        try {
            QueryWrapper<Article> wrapper = new QueryWrapper<>();
            Page<Article> page = new Page<>(currentPage, pageSize);
            if(keywords != null){
                wrapper.like("title", keywords);
            }
            if(type != null){
                wrapper.eq("sort_id", type);
            }
            if(createTime != null){
            }

            Page<Article> articlePage = articleMapper.selectPage(page, wrapper);

            // 遍历添加信息
            for(Article article : articlePage.getRecords()){
                User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", article.getUserId()));
                ArticleSort articleSort = articleSortMapper.selectOne(new QueryWrapper<ArticleSort>().eq("id", article.getSortId()));
                article.setSort(articleSort);
                article.setUser(user);
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
    public R deleteArticleById(Integer id) {
        try {
            QueryWrapper<Article> wrapper = new QueryWrapper<>();
            wrapper.eq("id", id);
            articleMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

    @Override
    public R deleteArticleListById(String ids) {
        try {
            QueryWrapper<Article> wrapper = new QueryWrapper<>();
            wrapper.in("id", ids.split(","));
            articleMapper.delete(wrapper);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.error("删除失败");
        }
    }

    @Override
    public R updateArticle(Article article) {
        try {
            article.setUpdateTime(new Date());
            articleMapper.updateById(article);
            return R.ok("更新成功");
        }catch (Exception e){
            return R.error("更新失败");
        }
    }

//    @Override
//    public R addArticle() {
//        return null;
//    }

}
