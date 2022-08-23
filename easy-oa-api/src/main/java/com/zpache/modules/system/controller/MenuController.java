package com.zpache.modules.system.controller;

import com.zpache.common.result.Result;
import com.zpache.common.utils.ResultUtils;
import com.zpache.entity.SysMenu;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc: 菜单管理
 * @author: zpache
 * @createTime: 2022/8/20 12:40
 */
@RestController
@RequestMapping("system/menu")
public class MenuController {

    @PostMapping("list")
    public Result<List<SysMenu>> list() {
        return ResultUtils.success();
    }

    @PostMapping("save")
    public Result save() {
        return ResultUtils.success();
    }

}
