package com.example.libarymanage.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BorrowRecordsDTO {
    private Date borrowTime;

    private Date shouldTime;

    private Date returnTime;

    private String bookNumber;

    private String bookName;

    private String author;

    private String translator;

    private String isbnCode;

    private Date comeupTime;

    private String publishCompany;

    private String enteringMen;

    private String userNumber;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
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

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getComeupTime() {
        return comeupTime;
    }

    public void setComeupTime(Date comeupTime) {
        this.comeupTime = comeupTime;
    }

    public String getPublishCompany() {
        return publishCompany;
    }

    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

    public String getEnteringMen() {
        return enteringMen;
    }

    public void setEnteringMen(String enteringMen) {
        this.enteringMen = enteringMen;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
