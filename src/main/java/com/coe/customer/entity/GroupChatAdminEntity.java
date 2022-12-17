package com.coe.customer.entity;

import javax.persistence.*;

@Entity
@Table(name = "group_chat_admin")
public class GroupChatAdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "group_chat_id")
    private GroupChatEntity groupChat;

    public GroupChatAdminEntity() {
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

    public GroupChatEntity getGroupChat() {
        return groupChat;
    }

    public void setGroupChat(GroupChatEntity groupChat) {
        this.groupChat = groupChat;
    }
}
