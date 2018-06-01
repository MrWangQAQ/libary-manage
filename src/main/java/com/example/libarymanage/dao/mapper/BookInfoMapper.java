package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.BookInfo;
import java.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookInfo record);

    BookInfo selectByPrimaryKey(Integer id);

    List<BookInfo> selectAll();

    int updateByPrimaryKey(BookInfo record);
}