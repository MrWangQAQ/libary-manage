package com.example.libarymanage.dao.mapper;

import com.example.libarymanage.entity.BorrowRecords;
import java.util.List;

public interface BorrowRecordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BorrowRecords record);

    BorrowRecords selectByPrimaryKey(Integer id);

    List<BorrowRecords> selectAll();

    int updateByPrimaryKey(BorrowRecords record);
}