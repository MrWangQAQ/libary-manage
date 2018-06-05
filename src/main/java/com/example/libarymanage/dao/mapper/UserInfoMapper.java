package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.UserInfo;
import com.example.libarymanage.entity.dto.UserList;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    List<UserInfo> selectAll();

    int updateByPrimaryKey(UserInfo record);

    List<UserList> getList(Map input);

    UserList selectUserInfoById(Integer userId);

    int editUserInfo(UserInfo record);
}