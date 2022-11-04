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
@TableName("index_nav")
public class IndexNav extends Model<IndexNav> {

    private static final long serialVersionUID = 1L;

    @TableField("title")
    private String title;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("path")
    private String path;

    @TableField("logo")
    private String logo;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
