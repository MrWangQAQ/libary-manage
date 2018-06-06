package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.SystemAdmin;
import java.util.List;
import java.util.Map;

public interface SystemAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemAdmin record);

    SystemAdmin selectByPrimaryKey(Integer id);

    List<SystemAdmin> selectAll();

    int updateByPrimaryKey(SystemAdmin record);

    SystemAdmin selectByAdminName(String adminName);

    int changePassword(SystemAdmin record);

    int editData(Map input);
}