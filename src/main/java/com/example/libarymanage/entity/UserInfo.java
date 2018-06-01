package com.example.libarymanage.entity;

public class UserInfo {
    private Integer id;

    private Integer userId;

    private String departments;

    private String major;

    private String phone;

    private String email;

    private Integer max;

    private Integer time;

    private Integer lendedNum;

    public UserInfo(Integer id, Integer userId, String departments, String major, String phone, String email, Integer max, Integer time, Integer lendedNum) {
        this.id = id;
        this.userId = userId;
        this.departments = departments;
        this.major = major;
        this.phone = phone;
        this.email = email;
        this.max = max;
        this.time = time;
        this.lendedNum = lendedNum;
    }

    public UserInfo() {
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

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments == null ? null : departments.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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
}