package com.hillel.crm.config.service;

import com.hillel.crm.config.entity.User;
import com.hillel.crm.config.entity.roles;

public class MainClass {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        UserService userService = new UserService();

        User user = User.builder()
                .firstName("mike")
                .lastName("mike")
                .password("123")
                .userRole(roles.DOCTOR)
                .email("DOCTOR")
                .build();
        UserService us = new UserService();
        //us.create(user);
    }
}
