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
 * @since 2022-11-05 13:24:34
 */
@Getter
@Setter
@TableName("safe_docker")
public class SafeDocker extends Model<SafeDocker> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("create_shell")
    private String createShell;

    @TableField("flag_addr")
    private String flagAddr;

    @TableField("nginx_shell")
    private String nginxShell;

    @TableField("intro_text")
    private String introText;

    @TableField("intro")
    private String intro;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
