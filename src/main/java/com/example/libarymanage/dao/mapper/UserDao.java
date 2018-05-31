package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User test();
}
