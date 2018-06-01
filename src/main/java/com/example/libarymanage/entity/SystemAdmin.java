package com.example.libarymanage.entity;

public class SystemAdmin {
    private Integer id;

    private String adminName;

    private String adminPassword;

    private String adminPhone;

    private String adminEmail;

    public SystemAdmin(Integer id, String adminName, String adminPassword, String adminPhone, String adminEmail) {
        this.id = id;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminPhone = adminPhone;
        this.adminEmail = adminEmail;
    }

    public SystemAdmin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail == null ? null : adminEmail.trim();
    }
}