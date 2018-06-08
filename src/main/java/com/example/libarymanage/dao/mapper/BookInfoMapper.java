package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.BookInfo;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookInfo record);

    BookInfo selectByPrimaryKey(Integer id);

    List<BookInfo> selectAll();

    int updateByPrimaryKey(BookInfo record);

    List<BookInfo> getList(Map input);

    List<BookInfo> getListByBookName(Map input);

    int getTotalCount();

    int backBook(BookInfo record);

    BookInfo getBookByNumber(String bookNumber);

    int borrowBook(BookInfo record);
}