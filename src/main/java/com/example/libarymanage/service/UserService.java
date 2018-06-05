package com.example.libarymanage.service;

import com.example.libarymanage.entity.User;

import java.util.Map;

public interface UserService extends BaseService{
    User selectByUserNumber(String userNumber);

    int insert(String number, String name);

    int deleteByUserId(Integer userId);

    int editUser(Map input);
}
