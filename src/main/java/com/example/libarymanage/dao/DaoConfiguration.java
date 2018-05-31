package com.example.libarymanage.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 配置注解
@MapperScan("com.example.libarymanage.dao.mapper")
public class DaoConfiguration {
}