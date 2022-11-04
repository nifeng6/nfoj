package com.jishu5.ctfcommunityserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author nifeng
 * @since 2022-11-04 18:43:46
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

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

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

    /**
     * 和reply_user_id对应，否则为空
     */
    @TableField("reply_user_name")
    private String replyUserName;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
