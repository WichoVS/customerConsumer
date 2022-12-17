package com.coe.kafkaproducer.model;


import com.coe.customer.entity.GroupChatAdminEntity;

import javax.persistence.*;

public class GroupChatAdmin {
    private int id;
    private Customer customer;
    private GroupChat groupChat;

    public GroupChatAdmin() {
    }

    public GroupChatAdmin(GroupChatAdminEntity entity) {
        this.id = entity.getId();
        this.customer = (entity.getCustomer() != null) ? new Customer(entity.getCustomer()) : null;
        this.groupChat = (entity.getGroupChat() != null) ? new GroupChat(entity.getGroupChat()) : null;
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

    public GroupChat getGroupChat() {
        return groupChat;
    }

    public void setGroupChat(GroupChat groupChat) {
        this.groupChat = groupChat;
    }
}
