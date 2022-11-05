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
 * @since 2022-11-05 13:24:34
 */
@Getter
@Setter
@TableName("safe_docker_user")
public class SafeDockerUser extends Model<SafeDockerUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("docker_id")
    private Integer dockerId;

    @TableField("lab_id")
    private Integer labId;

    @TableField("intro")
    private String intro;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("container_id")
    private String containerId;

    @TableField("exp_time")
    private LocalDateTime expTime;

    @TableField("docker_name")
    private String dockerName;

    @TableField("port")
    private String port;

    @TableField("is_exist")
    private String isExist;

    @TableField("is_success")
    private String isSuccess;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
