package com.example.libarymanage.serviceImpl;
import com.example.libarymanage.dao.mapper.UserDao;
import com.example.libarymanage.entity.User;
import com.example.libarymanage.service.testService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class testServiceImpl implements testService {
    private final UserDao userDao;

    public testServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User test(){
        return userDao.test();
    }
}
