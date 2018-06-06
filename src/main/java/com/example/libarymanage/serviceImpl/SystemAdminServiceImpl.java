package com.example.libarymanage.serviceImpl;

import com.example.libarymanage.dao.mapper.SystemAdminMapper;
import com.example.libarymanage.entity.SystemAdmin;
import com.example.libarymanage.service.SystemAdminService;
import com.example.libarymanage.utils.PasswordUtil;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public int changePassword(Map input){
        PasswordUtil passwordUtil = new PasswordUtil();
        SystemAdmin systemAdmin = new SystemAdmin();
        String password = input.get("password").toString();
        String truePassword = input.get("truePassword").toString();
        Boolean status = passwordUtil.verify(password, truePassword);
        if(status){
            String newPassword = passwordUtil.generate(input.get("newPassword").toString());
            systemAdmin.setAdminPassword(newPassword);
            systemAdmin.setId(Integer.parseInt(input.get("id").toString()));
            return systemAdminMapper.changePassword(systemAdmin);
        } else {
            return 0;
        }
    }

    @Override
    public int editData(Map input) {
        return systemAdminMapper.editData(input);
    }

    @Override
    public SystemAdmin getDataById(Integer id) {
        return systemAdminMapper.selectByPrimaryKey(id);
    }
}
