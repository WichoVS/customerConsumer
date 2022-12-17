package com.coe.kafkaproducer.model;

import com.coe.customer.entity.GroupChatEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class GroupChat {
    private int id;
    private String name;
    private Date createDate;

    public GroupChat() {
    }

    public GroupChat(GroupChatEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.createDate = entity.getCreateDate();
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
