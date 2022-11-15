package com.jishu5.ctfcommunityserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
@Getter
@Setter
@TableName("article_reply")
public class ArticleReply extends Model<ArticleReply> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("content")
    private String content;

    @TableField("user_id")
    private Integer userId;

    @TableField("reply_father_id")
    private Integer replyFatherId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 所属文章
     */
    @TableField("article_id")
    private Integer articleId;

    /**
     * 默认0，为第一层，否则对应一级回复的ID号
     */
    @TableField("reply_id")
    private Integer replyId;

    /**
     * 二级回复，用来确定子回复是回复谁的
     */
    @TableField("reply_user_id")
    private Integer replyUserId;


    @TableField(select = false,exist = false)
    private List<ArticleReply> replyList;

    @TableField(select = false,exist = false)
    private User user;

    @TableField(select = false,exist = false)
    private Article article;

    @TableField(select = false,exist = false)
    private User replyUser;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
