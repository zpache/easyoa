package com.zpache.modules.system.service;

import com.zpache.entity.SysMenu;
import com.zpache.modules.system.form.MenuForm;

import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2022/8/24 00:30
 */
public interface MenuService {

    List<SysMenu> list(MenuForm menuForm);

    SysMenu addMenu(SysMenu sysMenu);

    SysMenu updateMenu(SysMenu sysMenu);

    void save(SysMenu sysMenu);

    boolean deleteById(Long id);
}
