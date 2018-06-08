package com.example.libarymanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BorrowRecords {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Date borrowTime;

    private Date shouldTime;

    private Date returnTime;

    private Boolean state;

    public BorrowRecords(Integer id, Integer userId, Integer bookId, Date borrowTime, Date shouldTime, Date returnTime, Boolean state) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowTime = borrowTime;
        this.shouldTime = shouldTime;
        this.returnTime = returnTime;
        this.state = state;
    }

    public BorrowRecords(Integer userId, Integer bookId, Date borrowTime, Date shouldTime) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowTime = borrowTime;
        this.shouldTime = shouldTime;
    }

    public BorrowRecords( Date returnTime, Boolean state) {
        this.returnTime = returnTime;
        this.state = state;
    }

    public BorrowRecords() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getShouldTime() {
        return shouldTime;
    }

    public void setShouldTime(Date shouldTime) {
        this.shouldTime = shouldTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}