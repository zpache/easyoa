package com.zpache.modules.system.controller;

import com.zpache.common.result.Result;
import com.zpache.common.utils.ResultUtils;
import com.zpache.entity.SysMenu;
import com.zpache.modules.system.form.MenuForm;
import com.zpache.modules.system.service.MenuService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @desc: 菜单管理
 * @author: zpache
 * @createTime: 2022/8/20 12:40
 */
@RestController
@RequestMapping("api/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @PostMapping("list")
    public Result<List<SysMenu>> list(@RequestBody @Validated MenuForm menuForm) {
        List<SysMenu> list = menuService.list(menuForm);
        return ResultUtils.success(list);
    }

    @PostMapping("save")
    public Result save() {
        return ResultUtils.success();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam("id") Long id) {
        menuService.deleteById(id);
        return ResultUtils.success();
    }

}
