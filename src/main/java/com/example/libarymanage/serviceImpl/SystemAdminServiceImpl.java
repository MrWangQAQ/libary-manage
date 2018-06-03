package com.example.libarymanage.serviceImpl;

import com.example.libarymanage.dao.mapper.SystemAdminMapper;
import com.example.libarymanage.entity.SystemAdmin;
import com.example.libarymanage.service.SystemAdminService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SystemAdminServiceImpl implements SystemAdminService {
    private final SystemAdminMapper systemAdminMapper;

    public SystemAdminServiceImpl(SystemAdminMapper systemAdminMapper) {
        this.systemAdminMapper = systemAdminMapper;
    }

    @Override
    public SystemAdmin selectByAdminName(String adminName){
        return systemAdminMapper.selectByAdminName(adminName);
    }
}
