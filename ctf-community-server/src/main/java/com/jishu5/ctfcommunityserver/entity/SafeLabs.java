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
@TableName("safe_labs")
public class SafeLabs extends Model<SafeLabs> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("title")
    private String title;

    @TableField("intro")
    private String intro;

    @TableField("level")
    private Integer level;

    @TableField("label")
    private String label;

    @TableField("docker_id")
    private String dockerId;

    @TableField("type_id")
    private Integer typeId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("flag")
    private String flag;

    @TableField("need_coin")
    private String needCoin;

    @TableField("gold_coin")
    private String goldCoin;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
