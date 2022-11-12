package com.jishu5.ctfcommunityserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    // 可接收前端的值，但不进行返回
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    @TableField("password")
    private String password;

    @TableField("avatar_url")
    private String avatarUrl;

    @TableField("status")
    private Integer status;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField("description")
    private String description;

    @TableField("email")
    private String email;

    @TableField("phone")
    private String phone;

    @TableField("nick_name")
    private String nickName;

    @TableField("coin")
    private Integer coin;

    // 可接收前端的值，但不进行返回
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    @TableField(select = false,exist = false)
    private String captchaCode;

    // 可接收前端的值，但不进行返回
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    @TableField(select = false,exist = false)
    private String emailCode;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
