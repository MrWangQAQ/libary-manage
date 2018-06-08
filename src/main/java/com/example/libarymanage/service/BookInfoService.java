package com.example.libarymanage.service;

import com.example.libarymanage.entity.BookInfo;

import java.util.List;
import java.util.Map;

public interface BookInfoService extends BaseService{
    List<BookInfo> getList(Map input);

    List<BookInfo> getListByBookName(Map input);

    int getTotalCount();

    int addBook(BookInfo bookInfo);

    int deleteBook(Integer id);

    int editBook(BookInfo bookInfo);

    BookInfo selectBookById(Integer id);

    int backBook(int bookId);

    BookInfo getBookByNumber(String bookNumber);

    int borrowBook(int bookId);
}
