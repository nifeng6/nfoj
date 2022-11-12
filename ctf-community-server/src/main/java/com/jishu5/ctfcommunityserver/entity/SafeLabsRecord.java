package com.jishu5.ctfcommunityserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
@TableName("safe_labs_record")
public class SafeLabsRecord extends Model<SafeLabsRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "end_time", fill = FieldFill.INSERT)
    private Date endTime;

    @TableField("docker_name")
    private String dockerName;

    @TableField("user_id")
    private Integer userId;

    @TableField("lab_id")
    private Integer labId;

    @TableField("is_success")
    private Integer isSuccess;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
