package com.coe.kafkaproducer.model;

import com.coe.customer.entity.ChatMessageEntity;
import com.coe.customer.entity.GroupChatAdminEntity;
import com.coe.customer.entity.GroupChatMessageEntity;

import javax.persistence.*;
import java.sql.Date;

public class GroupChatMessage {
    private int id;
    private GroupChatAdmin groupChatAdmin;
    private ChatMessage chatMessage;
    private String content;
    private Date createDate;
    private String status;

    public GroupChatMessage() {
    }

    public GroupChatMessage(GroupChatMessageEntity entity) {
        this.id = entity.getId();
        this.groupChatAdmin = (entity.getGroupChatAdmin() != null) ? new GroupChatAdmin(entity.getGroupChatAdmin()) : null;
        this.chatMessage = (entity.getChatMessage() != null) ? new ChatMessage(entity.getChatMessage()) : null;
        this.content = entity.getContent();
        this.createDate = entity.getCreateDate();
        this.status = entity.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GroupChatAdmin getGroupChatAdmin() {
        return groupChatAdmin;
    }

    public void setGroupChatAdmin(GroupChatAdmin groupChatAdmin) {
        this.groupChatAdmin = groupChatAdmin;
    }

    public ChatMessage getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
