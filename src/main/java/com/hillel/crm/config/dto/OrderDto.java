package com.hillel.crm.config.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class OrderDto {

    private Long orderID;
    private Date dateCreating;
    private int totalPrice;
    private String stage;
    private String client;
    private String comments;
    private String responsibleUser;
}
