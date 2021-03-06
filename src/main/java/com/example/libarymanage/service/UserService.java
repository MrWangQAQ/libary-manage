package com.example.libarymanage.service;

import com.example.libarymanage.entity.User;
import com.example.libarymanage.entity.dto.UserList;

import java.util.Map;

public interface UserService extends BaseService{
    User selectByUserNumber(String userNumber);

    int insert(String number, String name);

    int deleteByUserId(Integer userId);

    int editUser(Map input);

    int getTotalCount();

    int changePassword(Map input);

    int resetPassword(Integer id);

    UserList getUserByNumber(String userNumber);
}
