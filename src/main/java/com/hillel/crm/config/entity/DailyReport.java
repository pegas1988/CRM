package com.hillel.crm.config.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "daily_report")
public class DailyReport {

    @Id
    private Long id;

    //private List<Product> madeProducts = new ArrayList<>();

    @Column(name = "date_of_report")
    private Date date;

    @Column(name = "responsible_person")
    private String responsiblePerson;

//    public List<Product> getMadeProducts() {
//        return madeProducts;
//    }
//
//    public void setMadeProducts(List<Product> madeProducts) {
//        this.madeProducts = madeProducts;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String user) {
        this.responsiblePerson = user;
    }
}
