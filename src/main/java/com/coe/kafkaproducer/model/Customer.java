package com.coe.kafkaproducer.model;

import com.coe.customer.entity.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private int id;
    private String name;
    private String preferredName;
    private String phoneNumber;
    private String email;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastTimeOnline;

    public Customer() {

    }

    public Customer(CustomerEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.preferredName = entity.getPreferredName();
        this.phoneNumber = entity.getPhoneNumber();
        this.email = entity.getEmail();
        this.status = entity.getStatus();
        this.createDate = entity.getCreateDate();
        this.lastTimeOnline = entity.getLastTimeOnline();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastTimeOnline() {
        return lastTimeOnline;
    }

    public void setLastTimeOnline(Date lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", preferredName='" + preferredName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", lastTimeOnline=" + lastTimeOnline +
                '}';
    }
}
