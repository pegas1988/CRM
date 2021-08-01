package com.hillel.crm.config.service;

import com.hillel.crm.config.entity.User;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class MainClass {
    public static void main(String[] args) {

        PropertyConfigurator.configure("D:\\MyApps\\CRM\\src\\main\\resources\\log4j.properties");

        ClientService clientService = new ClientService();
        UserService userService = new UserService();

        User user = User.builder()
                .firstName("mike")
                .lastName("mike")
                .password("123")
                //.userRole(roles.DOCTOR)
                .email("DOCTOR")
                .build();
        UserService us = new UserService();
        //us.create(user);
    }
}
