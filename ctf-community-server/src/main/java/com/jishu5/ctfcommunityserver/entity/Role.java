package com.jishu5.ctfcommunityserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Role {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("role_key")
    private String roleKey;

    // 所拥有权限列表
    @TableField(select = false,exist = false)
    private List<Integer> adminMenuIdList;

    @TableField(select = false,exist = false)
    private List<AdminMenu> adminMenuList;

}
