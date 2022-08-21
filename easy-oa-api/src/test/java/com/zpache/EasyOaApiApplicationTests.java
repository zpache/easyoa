package com.zpache;

import com.zpache.entity.SysMenu;
import com.zpache.mapper.SysMenuMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class EasyOaApiApplicationTests {

	@Resource
	private SysMenuMapper sysMenuMapper;

	@Test
	void contextLoads() {
		SysMenu sysMenu = new SysMenu();
		sysMenu.setName("工作台");
		sysMenuMapper.insert(sysMenu);
	}

}
