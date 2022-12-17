package com.coe.kafkaproducer.model;

import com.coe.customer.entity.ChatEntity;
import com.coe.customer.entity.ChatMessageEntity;

import javax.persistence.*;
import java.sql.Date;

public class ChatMessage {
    private int id;
    private ChatMessage chatReply;
    private String content;
    private Date createDate;
    private String status;
    private Chat chat;

    public ChatMessage() {
    }

    public ChatMessage(ChatMessageEntity entity) {
        this.id = entity.getId();
        this.chatReply = (entity.getChatReply() != null) ? new ChatMessage(entity.getChatReply()) : null;
        this.content = entity.getContent();
        this.createDate = entity.getCreateDate();
        this.status = entity.getStatus();
        this.chat = (entity.getChat() != null) ? new Chat(entity.getChat()) : null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChatMessage getChatReply() {
        return chatReply;
    }

    public void setChatReply(ChatMessage chatReply) {
        this.chatReply = chatReply;
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

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
