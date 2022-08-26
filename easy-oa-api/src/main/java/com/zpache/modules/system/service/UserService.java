package com.zpache.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.entity.SysUser;
import com.zpache.modules.system.form.UserForm;

import java.util.List;

/**
 * @desc:
 * @author: wang bing
 * @createTime: 2022/8/26 21:22
 */
public interface UserService {

    Page<SysUser> list(UserForm userForm);

    SysUser save(SysUser sysUser);

    void add(SysUser sysUser);

    void update(SysUser sysUser);

    boolean deleteById(Long id);
}
