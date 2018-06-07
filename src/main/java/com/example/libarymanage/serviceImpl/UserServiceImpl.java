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

    @Override
    public int changePassword(Map input){
        User user = new User();
        PasswordUtil passwordUtil = new PasswordUtil();
        String password = input.get("password").toString();
        String truePassword = input.get("truePassword").toString();
        Boolean status = passwordUtil.verify(password, truePassword);
        if(status){
            String newPassword = passwordUtil.generate(input.get("newPassword").toString());
            user.setPassword(newPassword);
            user.setId(Integer.parseInt(input.get("id").toString()));
            return userMapper.changePassword(user);
        } else {
            return 0;
        }
    }

    @Override
    public int resetPassword(Integer id){
        User user = new User();
        PasswordUtil passwordUtil = new PasswordUtil();
        String password = passwordUtil.generate("123456");
        user.setPassword(password);
        user.setId(id);
        return userMapper.changePassword(user);
}
}
