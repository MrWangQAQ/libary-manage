package com.example.libarymanage.entity;

import java.util.Date;

public class BorrowRecords {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private String bookName;

    private Date borrowTime;

    private Date shouldTime;

    private Date returnTime;

    private Boolean state;

    public BorrowRecords(Integer id, Integer userId, Integer bookId, String bookName, Date borrowTime, Date shouldTime, Date returnTime, Boolean state) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.borrowTime = borrowTime;
        this.shouldTime = shouldTime;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getShouldTime() {
        return shouldTime;
    }

    public void setShouldTime(Date shouldTime) {
        this.shouldTime = shouldTime;
    }

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