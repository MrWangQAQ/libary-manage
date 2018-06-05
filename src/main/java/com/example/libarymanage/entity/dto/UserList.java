package com.example.libarymanage.entity.dto;

public class UserList {
    private Integer id;

    private String userName;

    private String userNumber;

    private Integer userId;

    private String departments;

    private String major;

    private String phone;

    private String email;

    private Integer max;

    private Integer time;

    private Integer lendedNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getLendedNum() {
        return lendedNum;
    }

    public void setLendedNum(Integer lendedNum) {
        this.lendedNum = lendedNum;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
