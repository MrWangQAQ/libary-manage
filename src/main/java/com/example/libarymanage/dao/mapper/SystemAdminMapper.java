package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.SystemAdmin;
import java.util.List;

public interface SystemAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemAdmin record);

    SystemAdmin selectByPrimaryKey(Integer id);

    List<SystemAdmin> selectAll();

    int updateByPrimaryKey(SystemAdmin record);
}