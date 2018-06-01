package com.example.libarymanage.entity;

public class User {
    private String id;

    private String userName;

    private String password;

    private String userNumber;

    public User(String id, String userName, String password, String userNumber) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userNumber = userNumber;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }
}