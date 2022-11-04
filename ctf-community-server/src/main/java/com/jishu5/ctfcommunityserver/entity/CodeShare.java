package com.jishu5.ctfcommunityserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
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
@TableName("code_share")
public class CodeShare extends Model<CodeShare> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("content")
    private String content;

    @TableField("user_id")
    private Integer userId;

    @TableField("only_key")
    private String onlyKey;

    @TableField("type")
    private String type;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
