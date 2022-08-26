package com.zpache.modules.system.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2022/8/24 22:47
 */
@Data
public class MenuForm {
    @NotNull(message = "parentId不能为空")
    private Long parentId;
}
