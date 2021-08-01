package com.hillel.crm.config.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ClientDto {

    private Long ClientID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private String diagnose;
}
