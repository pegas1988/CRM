package com.hillel.crm.config.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long ClientID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private String diagnose;
}
