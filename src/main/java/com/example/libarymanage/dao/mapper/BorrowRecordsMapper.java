package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.BorrowRecords;
import com.example.libarymanage.entity.dto.BorrowRecordsDTO;

import java.util.List;
import java.util.Map;

public interface BorrowRecordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BorrowRecords record);

    BorrowRecords selectByPrimaryKey(Integer id);

    List<BorrowRecords> selectAll();

    int updateByPrimaryKey(BorrowRecords record);

    int backBook(BorrowRecords records);

    int borrowBook(BorrowRecords records);

    List<BorrowRecordsDTO> getBookList(Map input);

    List<BorrowRecordsDTO> getBookByNumber(Map input);

    int getTotalCountByNumber(String userNumber);

    List<BorrowRecordsDTO> getBookALLList(Map input);

    int getTotalCount();

    int getTotalCountBookByNumber(Map input);
}