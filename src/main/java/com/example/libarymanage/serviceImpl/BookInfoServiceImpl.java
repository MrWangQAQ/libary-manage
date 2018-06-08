package com.example.libarymanage.serviceImpl;

import com.example.libarymanage.dao.mapper.BookInfoMapper;
import com.example.libarymanage.entity.BookInfo;
import com.example.libarymanage.service.BookInfoService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class BookInfoServiceImpl implements BookInfoService {

    private final BookInfoMapper bookInfoMapper;

    public BookInfoServiceImpl(BookInfoMapper bookInfoMapper) {
        this.bookInfoMapper = bookInfoMapper;
    }

    @Override
    public List<BookInfo> getList(Map input){
        return bookInfoMapper.getList(input);
    }

    @Override
    public List<BookInfo> getListByBookName(Map input){
        return bookInfoMapper.getListByBookName(input);
    }

    @Override
    public int getTotalCount(){
        return bookInfoMapper.getTotalCount();
    }

    @Override
    public int addBook(BookInfo bookInfo){
        return bookInfoMapper.insert(bookInfo);
    }

    @Override
    public int deleteBook(Integer id){
        return bookInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int editBook(BookInfo bookInfo){
        return bookInfoMapper.updateByPrimaryKey(bookInfo);
    }

    @Override
    public BookInfo selectBookById(Integer id){
        return bookInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int backBook(int bookId){
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(bookId);
        bookInfo.setState(true);
        return bookInfoMapper.backBook(bookInfo);
    }

    @Override
    public BookInfo getBookByNumber(String bookNumber){
        return bookInfoMapper.getBookByNumber(bookNumber);
    }

    @Override
    public int borrowBook(int bookId){
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(bookId);
        bookInfo.setState(false);
        return bookInfoMapper.borrowBook(bookInfo);
    }
}
