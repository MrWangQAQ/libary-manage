package com.example.libarymanage.serviceImpl;

import com.example.libarymanage.dao.mapper.BookAdminMapper;
import com.example.libarymanage.entity.BookAdmin;
import com.example.libarymanage.service.BookAdminService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class BookAdminServiceImpl implements BookAdminService {
    private final BookAdminMapper bookAdminMapper;

    public BookAdminServiceImpl(BookAdminMapper bookAdminMapper) {
        this.bookAdminMapper = bookAdminMapper;
    }

    @Override
    public BookAdmin selectByAdName(String adName){
        return bookAdminMapper.selectByAdName(adName);
    }
}
