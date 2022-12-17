package com.coe.kafkaproducer.model;

import com.coe.customer.entity.ChatEntity;
import com.coe.customer.entity.CustomerEntity;
import com.coe.customer.entity.PhoneBookEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

public class Chat {
    private int id;
    private CustomerEntity customer;
    private PhoneBookEntity phoneBook;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;

    public Chat() {
    }

    public Chat(ChatEntity entity) {
        this.id = entity.getId();
        this.customer = entity.getCustomer();
        this.phoneBook = entity.getPhoneBook();
        this.createDate = entity.getCreateDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public PhoneBookEntity getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(PhoneBookEntity phoneBook) {
        this.phoneBook = phoneBook;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
