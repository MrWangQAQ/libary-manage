package com.example.libarymanage.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 配置注解
@PropertySource(value = "classpath:application.properties")
@MapperScan("com.example.librarymanage.dao.mapper")
public class DaoConfiguration {
}