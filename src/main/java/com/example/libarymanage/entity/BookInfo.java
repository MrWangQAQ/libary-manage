package com.example.libarymanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BookInfo {
    private Integer id;

    private String bookNumber;

    private String bookName;

    private String author;

    private String translator;

    private String isbnCode;

    private Date comeupTime;

    private String publishCompany;

    private Boolean state;

    private String enteringMen;

    private Date enteringDate;

    public BookInfo(Integer id, String bookNumber, String bookName, String author, String translator, String isbnCode, Date comeupTime, String publishCompany, Boolean state, String enteringMen, Date enteringDate) {
        this.id = id;
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.author = author;
        this.translator = translator;
        this.isbnCode = isbnCode;
        this.comeupTime = comeupTime;
        this.publishCompany = publishCompany;
        this.state = state;
        this.enteringMen = enteringMen;
        this.enteringDate = enteringDate;
    }

    public BookInfo(String bookNumber, String bookName, String author, String translator, String isbnCode, Date comeupTime, String publishCompany, Boolean state, String enteringMen, Date enteringDate) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.author = author;
        this.translator = translator;
        this.isbnCode = isbnCode;
        this.comeupTime = comeupTime;
        this.publishCompany = publishCompany;
        this.state = state;
        this.enteringMen = enteringMen;
        this.enteringDate = enteringDate;
    }

    public BookInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode == null ? null : isbnCode.trim();
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
        this.publishCompany = publishCompany == null ? null : publishCompany.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getEnteringMen() {
        return enteringMen;
    }

    public void setEnteringMen(String enteringMen) {
        this.enteringMen = enteringMen == null ? null : enteringMen.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getEnteringDate() {
        return enteringDate;
    }

    public void setEnteringDate(Date enteringDate) {
        this.enteringDate = enteringDate;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }
}