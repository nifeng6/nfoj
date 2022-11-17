package com.jishu5.ctfcommunityserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

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
@TableName("article")
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField("tags")
    private String tags;

    @TableField("type_id")
    private Integer typeId;

    @TableField("user_id")
    private Integer userId;

    @TableField("view")
    private Integer view;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    // 以下不从数据库中查找
    @TableField(select = false,exist = false)
    private String typeName;

    @TableField(select = false,exist = false)
    private Integer replyCount;

    @TableField(select = false,exist = false)
    private User user;

    @TableField(select = false,exist = false)
    private ArticleType type;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
