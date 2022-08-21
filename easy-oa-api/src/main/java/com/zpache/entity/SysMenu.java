package com.zpache.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.Valid;
import java.util.Date;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2022/8/22 02:56
 */
@Data
@TableName(value = "sys_menu")
public class SysMenu {
    @TableId(value = "id")
    private Long id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "icon")
    private String icon;
    @TableField(value = "type")
    private Integer type;
    @TableField(value = "parent_Id")
    private Long parentId;
    @TableField(value = "route")
    private String route;
    @TableField(value = "permission")
    private String permission;
    @TableField(value = "sort")
    private Integer sort;
    @TableLogic
    private Integer isDelete;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "create_user")
    private String createUser;
    @TableField(value = "update_time", updateStrategy = FieldStrategy.IGNORED)
    private Date updateTime;
    @TableField(value = "update_user")
    private String updateUser;
    @Version
    @TableField(value = "version")
    private Integer version;
}
