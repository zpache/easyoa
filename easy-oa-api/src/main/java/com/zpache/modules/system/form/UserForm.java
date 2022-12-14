package com.zpache.modules.system.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2022/8/26 21:21
 */
@Data
public class UserForm {
    private String name;
    private String mobile;
    private String workNo;
    private Integer status;
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;
    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;
}
