package com.hillel.crm.config.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
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
}
