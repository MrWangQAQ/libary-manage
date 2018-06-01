package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.BookAdmin;
import java.util.List;

public interface BookAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookAdmin record);

    BookAdmin selectByPrimaryKey(Integer id);

    List<BookAdmin> selectAll();

    int updateByPrimaryKey(BookAdmin record);
}