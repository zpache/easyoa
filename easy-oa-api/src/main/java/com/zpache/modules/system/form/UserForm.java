package com.zpache.modules.system.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @desc:
 * @author: wang bing
 * @createTime: 2022/8/26 21:21
 */
@Data
public class UserForm {
    private String name;
    private String mobile;
    private String workNo;
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;
    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;
}
