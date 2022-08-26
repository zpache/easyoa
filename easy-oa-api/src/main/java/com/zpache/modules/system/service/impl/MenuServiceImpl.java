package com.zpache.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zpache.common.exception.ServiceException;
import com.zpache.entity.SysMenu;
import com.zpache.mapper.SysMenuMapper;
import com.zpache.modules.system.form.MenuForm;
import com.zpache.modules.system.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2022/8/24 00:30
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> list(MenuForm menuForm) {
        LambdaQueryWrapper<SysMenu> queryWrapper = new QueryWrapper<SysMenu>().lambda()
                .eq(SysMenu::getParentId, menuForm.getParentId());
        return sysMenuMapper.selectList(queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysMenu addMenu(SysMenu sysMenu) {
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysMenu updateMenu(SysMenu sysMenu) {
        int i = sysMenuMapper.updateById(sysMenu);
        return sysMenu;
    }

    @Override
    public void save(SysMenu sysMenu) {
        if (sysMenu.getId() == null) {
            addMenu(sysMenu);
        } else {
            updateMenu(sysMenu);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        LambdaQueryWrapper<SysMenu> queryWrapper = new QueryWrapper<SysMenu>().lambda()
                .eq(SysMenu::getParentId, id);
        List<SysMenu> subMenuList = sysMenuMapper.selectList(queryWrapper);
        if (subMenuList == null) {
            sysMenuMapper.deleteById(id);
            return true;
        } else {
            throw new ServiceException("请先删除子节点");
        }
    }
}
