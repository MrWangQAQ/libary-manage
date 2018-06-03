package com.example.libarymanage.serviceImpl;

import com.example.libarymanage.dao.mapper.UserMapper;
import com.example.libarymanage.entity.User;
import com.example.libarymanage.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectByUserNumber(String userNumber){
        return userMapper.selectByUserNumber(userNumber);
    }
}
