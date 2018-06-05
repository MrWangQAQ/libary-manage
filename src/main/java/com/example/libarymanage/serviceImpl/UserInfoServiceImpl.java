package com.example.libarymanage.serviceImpl;

import com.example.libarymanage.dao.mapper.UserInfoMapper;
import com.example.libarymanage.entity.UserInfo;
import com.example.libarymanage.entity.dto.UserList;
import com.example.libarymanage.service.UserInfoService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoMapper userInfoMapper;

    public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public List<UserList> getList(Map input){
        return userInfoMapper.getList(input);
    }

    @Override
    public int insert(Map input){
        UserInfo userInfo = new UserInfo();
        userInfo.setDepartments(input.get("departments").toString());
        userInfo.setEmail(input.get("email").toString());
        userInfo.setMax(Integer.parseInt(input.get("max").toString()));
        userInfo.setPhone(input.get("phone").toString());
        userInfo.setTime(Integer.parseInt(input.get("time").toString()));
        userInfo.setUserId(Integer.parseInt(input.get("userId").toString()));
        userInfo.setMajor(input.get("major").toString());
        userInfo.setLendedNum(0);  //初始化在借数量为0
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public UserList selectUserInfoById(Integer userId){
        return userInfoMapper.selectUserInfoById(userId);
    }

    @Override
    public int deleteByUserInfoId(Integer userInfoId){
        return userInfoMapper.deleteByPrimaryKey(userInfoId);
    }

    @Override
    public int updateByPrimaryKey(Map input){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Integer.parseInt(input.get("userInfoId").toString()));
        userInfo.setDepartments(input.get("departments").toString());
        userInfo.setEmail(input.get("email").toString());
        userInfo.setMax(Integer.parseInt(input.get("max").toString()));
        userInfo.setPhone(input.get("phone").toString());
        userInfo.setTime(Integer.parseInt(input.get("time").toString()));
        userInfo.setUserId(Integer.parseInt(input.get("userId").toString()));
        userInfo.setMajor(input.get("major").toString());
        return userInfoMapper.editUserInfo(userInfo);
    }
}
