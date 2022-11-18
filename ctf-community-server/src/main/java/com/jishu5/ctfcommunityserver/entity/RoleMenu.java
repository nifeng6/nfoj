package com.jishu5.ctfcommunityserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("role_menu")
@Data
public class RoleMenu {

    @TableField("role_id")
    private Integer roleId;

    @TableField("menu_id")
    private Integer menuId;

}
