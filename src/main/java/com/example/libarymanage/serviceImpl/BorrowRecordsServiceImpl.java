package com.example.libarymanage.serviceImpl;

import com.example.libarymanage.dao.mapper.BorrowRecordsMapper;
import com.example.libarymanage.entity.BorrowRecords;
import com.example.libarymanage.entity.dto.BorrowRecordsDTO;
import com.example.libarymanage.service.BorrowRecordsService;
import com.example.libarymanage.utils.PasswordUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class BorrowRecordsServiceImpl implements BorrowRecordsService {

    private final BorrowRecordsMapper borrowRecordsMapper;

    public BorrowRecordsServiceImpl(BorrowRecordsMapper borrowRecordsMapper) {
        this.borrowRecordsMapper = borrowRecordsMapper;
    }

    @Override
    public int borrowBook(BorrowRecords records){
        records.setState(false);
        return borrowRecordsMapper.borrowBook(records);
    }

    @Override
    public int backBook(BorrowRecords records){
        records.setState(true);
        return borrowRecordsMapper.backBook(records);
    }

    @Override
    public List<BorrowRecordsDTO> getBookList(Map input){
        return borrowRecordsMapper.getBookList(input);
    }

    @Override
    public List<BorrowRecordsDTO> getBookByNumber(Map input){
        return borrowRecordsMapper.getBookByNumber(input);
    }

    @Override
    public int getTotalCountByNumber(String userNumber) {
        return borrowRecordsMapper.getTotalCountByNumber(userNumber);
    }

    @Override
    public List<BorrowRecordsDTO> getBookALLList(Map input){
        return borrowRecordsMapper.getBookALLList(input);
    }

    @Override
    public int getTotalCount(){
        return borrowRecordsMapper.getTotalCount();
    }

    @Override
    public int getTotalCountBookByNumber(String userNumber, Boolean state){
        Map input = new HashMap();
        input.put("userNumber", userNumber);
        input.put("state", state);
        return borrowRecordsMapper.getTotalCountBookByNumber(input);
    }

}
