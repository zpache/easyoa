package com.zpache;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@MapperScan(basePackages = "com.zpache.mapper")
@SpringBootApplication
public class EasyOaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyOaApiApplication.class, args);
		log.info("<服务启动><EASYOA><服务启动成功...>");
	}

}
