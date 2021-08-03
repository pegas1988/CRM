package com.hillel.crm.config.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long orderID;
    private Date dateCreating;
    private int totalPrice;
    private String stage;
    private String client;
    private String comments;
    private String responsibleUser;
}
