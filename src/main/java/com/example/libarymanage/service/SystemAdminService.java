package com.example.libarymanage.service;

import com.example.libarymanage.entity.SystemAdmin;

import java.util.Map;

public interface SystemAdminService extends BaseService {
    SystemAdmin selectByAdminName(String adminName);

    int changePassword(Map input);

    int editData(Map input);

    SystemAdmin getDataById(Integer id);
}
