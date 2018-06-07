package com.example.libarymanage.service;

import com.example.libarymanage.entity.UserInfo;
import com.example.libarymanage.entity.dto.UserList;

import java.util.List;
import java.util.Map;

public interface UserInfoService extends BaseService {

    List<UserList> getList(Map input);

    int insert(Map input);

    UserList selectUserInfoById(Integer userId);

    int deleteByUserInfoId(Integer userInfoId);

    int updateByPrimaryKey(Map input);

    int changeInformation(Map input);
}
