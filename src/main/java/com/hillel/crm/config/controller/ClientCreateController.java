package com.hillel.crm.config.controller;

import com.hillel.crm.config.entity.Client;
import com.hillel.crm.config.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientCreateController implements Controller {
    ClientService clientService = new ClientService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String clientName = req.getParameter("clientName");
        String clientLastName = req.getParameter("clientLastName");
        String gender = req.getParameter("gender");
        Client client = Client.builder()
                .firstName(clientName)
                .lastName(clientLastName)
                .sex(gender)
                .build();
//        clientService.create(client);
        return new ControllerResultDto("clientCreated", true);
    }
}
