package com.coe.kafkaproducer.model;

import com.coe.customer.entity.CustomerEntity;
import com.coe.customer.entity.PhoneBookEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

public class PhoneBook {
    private int id;
    private Customer customer;
    private Customer myContact;
    private String nickname;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateDate;

    public PhoneBook() {
    }

    public PhoneBook(PhoneBookEntity entity) {
        this.id = entity.getId();
        this.customer = (entity.getCustomer() != null) ? new Customer(entity.getCustomer()) : null;
        this.myContact = (entity.getMyContact() != null) ? new Customer(entity.getMyContact()) : null;
        this.nickname = entity.getNickname();
        this.createDate = entity.getCreateDate();
        this.updateDate = entity.getUpdateDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getMyContact() {
        return myContact;
    }

    public void setMyContact(Customer myContact) {
        this.myContact = myContact;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
