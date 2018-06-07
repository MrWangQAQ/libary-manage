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
}
