package com.example.libarymanage.entity;

public class BookAdmin {
    private Integer id;

    private String adName;

    private String adPassword;

    private String adPhone;

    private String admail;

    public BookAdmin(Integer id, String adName, String adPassword, String adPhone, String admail) {
        this.id = id;
        this.adName = adName;
        this.adPassword = adPassword;
        this.adPhone = adPhone;
        this.admail = admail;
    }

    public BookAdmin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName == null ? null : adName.trim();
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword == null ? null : adPassword.trim();
    }

    public String getAdPhone() {
        return adPhone;
    }

    public void setAdPhone(String adPhone) {
        this.adPhone = adPhone == null ? null : adPhone.trim();
    }

    public String getAdmail() {
        return admail;
    }

    public void setAdmail(String admail) {
        this.admail = admail == null ? null : admail.trim();
    }
}