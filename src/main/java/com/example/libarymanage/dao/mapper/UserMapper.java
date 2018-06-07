package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByUserNumber(String userNumber);

    int editUser(User record);

    int getTotalCount();

    int changePassword(User record);
}