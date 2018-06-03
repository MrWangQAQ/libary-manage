package com.example.libarymanage.service;

import com.example.libarymanage.entity.BookAdmin;

public interface BookAdminService extends BaseService{
    BookAdmin selectByAdName(String adName);
}
