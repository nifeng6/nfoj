package com.jishu5.ctfcommunityserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName("admin_menu")
public class AdminMenu {

    @TableField("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("path")
    private String path;

    @TableField("status")
    private Integer status;

    @TableField("icon")
    private String icon;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("parent_id")
    private Integer parentId;

    @TableField(select = false,exist = false)
    private List<AdminMenu> childMenuList;

}
