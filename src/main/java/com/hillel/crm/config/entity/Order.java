package com.hillel.crm.config.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    private Integer orderID;

    @Column(name = "creating_day")
    private Date dateCreating;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "order_stage")
    private String stage;

    @Column(name = "client_fio")
    private String client;

    @Column(name = "comment")
    private String comments;

    @Column(name = "responsible_person")
    private String responsibleUser;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public java.lang.String getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(java.lang.String responsibleUser) {
        this.responsibleUser = responsibleUser;
    }

    public java.lang.String getComments() {
        return comments;
    }

    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }

    public Date getDateCreating() {
        return dateCreating;
    }

    public void setDateCreating(Date dateCreating) {
        this.dateCreating = dateCreating;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public java.lang.String getStage() {
        return stage;
    }

    public void setStage(java.lang.String stage) {
        this.stage = stage;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
