package com.zpache.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.common.exception.ServiceException;
import com.zpache.common.utils.StringUtils;
import com.zpache.entity.SysUser;
import com.zpache.mapper.SysUserMapper;
import com.zpache.modules.system.form.UserForm;
import com.zpache.modules.system.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2022/8/26 21:24
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public Page<SysUser> list(UserForm userForm) {
        Page pageParam = new Page(userForm.getPageNum(), userForm.getPageSize());
        LambdaQueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().lambda()
                .like(StringUtils.isNotBlank(userForm.getName()), SysUser::getName, userForm.getName())
                .eq(StringUtils.isNotBlank(userForm.getMobile()), SysUser::getMobile, userForm.getMobile())
                .eq(StringUtils.isNotBlank(userForm.getWorkNo()), SysUser::getWorkNo, userForm.getWorkNo())
                .eq(userForm.getStatus() != null, SysUser::getStatus, userForm.getStatus());
        return sysUserMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public SysUser save(SysUser sysUser) {
        if (sysUser.getId() == null) {
            LambdaQueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().lambda().eq(SysUser::getLoginName, sysUser.getLoginName());
            SysUser selectOne = sysUserMapper.selectOne(queryWrapper);
            if (selectOne != null) {
                throw new ServiceException(String.format("用户名已存在[%s]", sysUser.getLoginName()));
            }
            add(sysUser);
        } else {
            update(sysUser);
        }
        return sysUserMapper.selectById(sysUser.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(SysUser sysUser) {
        int num = sysUserMapper.insert(sysUser);
        if (num == 0) {
            throw new ServiceException("用户保存失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(SysUser sysUser) {
        int num = sysUserMapper.updateById(sysUser);
        if (num < 1) {
            throw new ServiceException("用户修改失败");
        }
    }

    @Override
    public boolean deleteById(Long id) {
        int i = sysUserMapper.deleteById(id);
        if (i == 0) {
            throw new ServiceException("用户删除失败");
        }
        return true;
    }
}
