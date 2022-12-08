package com.coe.customer.entity;

import com.coe.kafkaproducer.model.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "preferred_name")
    private String preferredName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "status")
    private String status;
    @Column(name = "create_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;
    @Column(name = "last_time_online")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastTimeOnline;

    public CustomerEntity() {
    }

    public CustomerEntity(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.preferredName = customer.getPreferredName();
        this.phoneNumber = customer.getPhoneNumber();
        this.email = customer.getEmail();
        this.status = customer.getStatus();
        this.createDate = customer.getCreateDate();
        this.lastTimeOnline = customer.getLastTimeOnline();
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
        return "CustomerEntity{" +
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

    public void updateEntity(Customer customer){
        this.name = customer.getName();
        this.preferredName = customer.getPreferredName();
        this.phoneNumber = customer.getPhoneNumber();
        this.email = customer.getEmail();
    }
}
