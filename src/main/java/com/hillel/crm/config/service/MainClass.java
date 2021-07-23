package com.hillel.crm.config.service;

import com.hillel.crm.config.entity.User;
import com.hillel.crm.config.entity.roles;

public class MainClass {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        UserService userService = new UserService();

        User user = new User("mike", "mike", "123", "DOCTOR", roles.DOCTOR);
        UserService us = new UserService();
        //us.create(user);
    }
}
