package com.zpache.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2022/8/22 02:56
 */
@Data
@TableName(value = "sys_menu")
public class SysMenu {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "icon")
    private String icon;
    @TableField(value = "type")
    private Integer type;
    @TableField(value = "parentId")
    private Long parentId;
    @TableField(value = "route")
    private String route;
    @TableField(value = "permission")
    private String permission;
    @TableField(value = "sort")
    private Integer sort;
    @TableField(value = "isDelete")
    private Integer isDelete;
    @TableField(value = "createTime")
    private Date createTime;
    @TableField(value = "createUser")
    private String createUser;
    @TableField(value = "updateTime")
    private Date updateTime;
    @TableField(value = "updateUser")
    private String updateUser;
    @TableField(value = "version")
    private Integer version;
}
