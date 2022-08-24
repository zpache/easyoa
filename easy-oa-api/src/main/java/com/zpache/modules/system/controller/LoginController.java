package com.zpache.modules.system.controller;

import com.zpache.common.result.Result;
import com.zpache.common.utils.ResultUtils;
import com.zpache.modules.system.form.LoginForm;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @desc:
 * @author: wang bing
 * @createTime: 2022/8/25 00:06
 */
@RestController
@RequestMapping("api")
public class LoginController {



    @PostMapping("user/login")
    public Result login(@RequestBody LoginForm loginForm) {
        Map<String, Object> data = new HashMap<>();
        data.put("token", UUID.randomUUID());
        return ResultUtils.success(data);
    }

    @PostMapping("user/info")
    public Result userInfo(@RequestParam("token") String token) {
        Map<String, Object> data = new HashMap<>();
        data.put("roles", new String[]{"admin"});
        data.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        data.put("name", "Ryan");
        return ResultUtils.success(data);
    }
}
