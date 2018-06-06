package com.example.libarymanage.serviceImpl;

import com.example.libarymanage.dao.mapper.UserMapper;
import com.example.libarymanage.entity.User;
import com.example.libarymanage.service.UserService;
import com.example.libarymanage.utils.PasswordUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

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

    @Override
    public int insert(String number, String name){
        User user = new User();
        user.setUserNumber(number);
        user.setUserName(name);
        PasswordUtil passwordUtil = new PasswordUtil();
        String password = passwordUtil.generate("123456");
        user.setPassword(password);
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public int deleteByUserId(Integer userId){
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int editUser(Map input){
        User record = new User();
        record.setId(Integer.parseInt(input.get("userId").toString()));
        record.setUserName(input.get("userName").toString());
        record.setUserNumber(input.get("userNumber").toString());
        return userMapper.editUser(record);
    }

    @Override
    public int getTotalCount(){
        return userMapper.getTotalCount();
    }
}
