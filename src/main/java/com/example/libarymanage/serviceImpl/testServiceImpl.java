package com.example.libarymanage.serviceImpl;
import com.example.libarymanage.dao.mapper.UserMapper;
import com.example.libarymanage.entity.User;
import com.example.libarymanage.service.testService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class testServiceImpl implements testService {
    private final UserMapper userMapper;

    public testServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> test(){
        return userMapper.selectAll();
    }
}
