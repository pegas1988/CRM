package com.hillel.crm.config.service.rest;

import com.hillel.crm.config.dto.ClientDto;
import com.hillel.crm.config.entity.Client;
import java.util.List;

public interface ClientServiceRest {
    public Client getById(Long id);

    List<Client> findAll();

    Client create(ClientDto clientDto);

    public void delete(Long id);

    public void update(Long id, ClientDto clientDto);
}
