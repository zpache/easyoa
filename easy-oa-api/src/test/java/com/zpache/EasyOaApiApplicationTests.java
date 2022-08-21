package com.zpache;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zpache.entity.SysMenu;
import com.zpache.mapper.SysMenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class EasyOaApiApplicationTests {

	@Resource
	private SysMenuMapper sysMenuMapper;

	@Test
	void contextLoads() {
		LambdaQueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>().lambda().eq(SysMenu::getId, 1L);
		SysMenu sysMenu1 = sysMenuMapper.selectOne(wrapper);

		sysMenu1.setName("工作台");
		sysMenuMapper.updateById(sysMenu1);
	}

}
