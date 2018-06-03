package com.example.libarymanage.service;

import com.example.libarymanage.entity.SystemAdmin;

public interface SystemAdminService extends BaseService {
    SystemAdmin selectByAdminName(String adminName);
}
