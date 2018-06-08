package com.example.libarymanage.service;

import com.example.libarymanage.entity.BorrowRecords;
import com.example.libarymanage.entity.dto.BorrowRecordsDTO;

import java.util.List;
import java.util.Map;

public interface BorrowRecordsService extends BaseService {
    int borrowBook(BorrowRecords records);

    int backBook(BorrowRecords records);

    List<BorrowRecordsDTO> getBookList(Map input);

    List<BorrowRecordsDTO> getBookByNumber(Map input);

    int getTotalCountByNumber(String userNumber);

    List<BorrowRecordsDTO> getBookALLList(Map input);

    int getTotalCount();

    int getTotalCountBookByNumber(String userNumber, Boolean state);
}
