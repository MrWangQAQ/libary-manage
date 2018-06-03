package com.example.libarymanage.service;

import com.example.libarymanage.entity.User;

public interface UserService extends BaseService{
    User selectByUserNumber(String userNumber);
}
