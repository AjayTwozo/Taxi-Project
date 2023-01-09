package com.TaxiProject.model;

/**
 * User's pattern
 * Contains id, name, mobile number, password, email ID
 *
 * @author Ajay
 * @version 1.0
 */
public class User {

    private Long id;
    private String name;
    private String mobileNumber;
    private String password;
    private String emailId;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}