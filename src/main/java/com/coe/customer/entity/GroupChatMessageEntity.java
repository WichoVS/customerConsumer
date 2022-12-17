package com.coe.customer.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "group_chat_message")
public class GroupChatMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "group_chat_admin_id")
    private GroupChatAdminEntity groupChatAdmin;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "chat_message_fk")
    private ChatMessageEntity chatMessage;
    @Column(name = "content")
    private String content;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "status")
    private String status;

    public GroupChatMessageEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GroupChatAdminEntity getGroupChatAdmin() {
        return groupChatAdmin;
    }

    public void setGroupChatAdmin(GroupChatAdminEntity groupChatAdmin) {
        this.groupChatAdmin = groupChatAdmin;
    }

    public ChatMessageEntity getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(ChatMessageEntity chatMessage) {
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
