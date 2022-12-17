package com.coe.customer.entity;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "chat_message")
public class ChatMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_message_fk", referencedColumnName = "id")
    private ChatMessageEntity chatReply;
    @Column(name = "content")
    private String content;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "status")
    private String status;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "chat_id")
    private ChatEntity chat;

    public ChatMessageEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChatMessageEntity getChatReply() {
        return chatReply;
    }

    public void setChatReply(ChatMessageEntity chatReply) {
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

    public ChatEntity getChat() {
        return chat;
    }

    public void setChat(ChatEntity chat) {
        this.chat = chat;
    }
}
