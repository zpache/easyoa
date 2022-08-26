package com.zpache.modules.system.controller;

import com.zpache.common.result.Result;
import com.zpache.common.utils.ResultUtils;
import com.zpache.entity.SysUser;
import com.zpache.modules.system.form.UserForm;
import com.zpache.modules.system.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @desc: 用户管理
 * @author: zpache
 * @createTime: 2022/8/20 12:40
 */
@RestController
@RequestMapping("api/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("list")
    public Result list(@RequestBody @Validated UserForm userForm) {
        return ResultUtils.success(userService.list(userForm));
    }

    @PostMapping("save")
    public Result save(@RequestBody SysUser sysUser) {
        userService.save(sysUser);
        return ResultUtils.success();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam("userId") Long userId) {
        userService.deleteById(userId);
        return ResultUtils.success();
    }
}
