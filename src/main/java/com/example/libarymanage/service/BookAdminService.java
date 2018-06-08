package com.example.libarymanage.service;

import com.example.libarymanage.entity.BookAdmin;

import java.util.List;
import java.util.Map;

public interface BookAdminService extends BaseService{
    BookAdmin selectByAdName(String adName);

    List<BookAdmin> getList(Map input);

    int editById(Map input);

    BookAdmin selectById(Integer id);

    int deleteById(Integer id);

    int addBookAdmin(Map input);

    int getTotalCount();

    int changePassword(Map input);
}
