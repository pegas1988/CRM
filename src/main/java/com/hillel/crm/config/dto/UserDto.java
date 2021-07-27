package com.hillel.crm.config.dto;

import com.hillel.crm.config.entity.roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String userRole;
}
