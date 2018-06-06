package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.BookAdmin;
import java.util.List;
import java.util.Map;

public interface BookAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookAdmin record);

    BookAdmin selectByPrimaryKey(Integer id);

    List<BookAdmin> selectAll();

    int updateByPrimaryKey(BookAdmin record);

    BookAdmin selectByAdName(String adName);

    List<BookAdmin> getList(Map input);

    int editById(BookAdmin record);

    int changePassword(BookAdmin record);

    BookAdmin selectById(Integer id);

    int getTotalCount();
}