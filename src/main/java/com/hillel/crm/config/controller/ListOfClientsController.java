package com.hillel.crm.config.controller;

import com.hillel.crm.config.entity.Client;
import com.hillel.crm.config.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListOfClientsController implements Controller {

    private final Client VIEW_NAME;

    public ListOfClientsController(Client VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    ClientService clientService = new ClientService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       // List<Client> materials = clientService.findAll();
       // req.setAttribute("list", materials);
        return new ControllerResultDto(VIEW_NAME.toString());
    }
}

