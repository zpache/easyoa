package com.zpache.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.zpache.common.typehandler.PasswordTypeHandler;
import lombok.Data;

import java.util.Date;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2022/8/26 21:08
 */
@TableName(value = "sys_user")
@Data
public class SysUser {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "login_name")
    private String loginName;
    @TableField(value = "nick_name")
    private String nickName;
    @TableField(value = "password",typeHandler = PasswordTypeHandler.class)
    private String password;
    @TableField(value = "dep_id")
    private String depId;
    @TableField(value = "dep_name")
    private String depName;
    @TableField(value = "mobile")
    private String mobile;
    @TableField(value = "email")
    private String email;
    @TableField(value = "open_id")
    private String openId;
    @TableField(value = "gender")
    private String gender;
    @TableField(value = "work_no")
    private String workNo;
    @TableField(value = "avatar")
    private String avatar;
    @TableField(value = "status")
    private Integer status;
    @TableLogic
    private Integer isDelete;
    @TableField(value = "create_user")
    private String createUser;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "update_user")
    private String updateUser;
    @TableField(value = "update_time")
    private String updateTime;
    @TableField(value = "version")
    private Integer version;
}
