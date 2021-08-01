package com.hillel.crm.config.service.impl;

import com.hillel.crm.config.dao.ClientDao;
import com.hillel.crm.config.dto.ClientDto;
import com.hillel.crm.config.entity.Client;
import com.hillel.crm.config.service.rest.ClientServiceRest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientServiceRestImpl implements ClientServiceRest {

    private final ClientDao clientDao;

    @Override
    public Client getById(Long id) throws RuntimeException {
        Client client = clientDao.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("не удалось найти Client с id " + id));
        return client;
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    @Transactional
    public Client create(ClientDto clientDto) {
        if (!Objects.isNull(clientDto.getClientID())) {
            throw new IllegalArgumentException("Failed to create Client. Client with such ID already exist.");
        }
        Client user = new Client();
        BeanUtils.copyProperties(clientDto, user);
        return clientDao.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!clientDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to delete client. Client with such ID doesnt exist.");
        }
        clientDao.deleteById(id);
    }

    @Override
    public void update(Long id, ClientDto clientDto) {
        if (!clientDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to delete user. User with such ID doesnt exist.");
        }
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        client.setClientID(id);
        clientDao.save(client);
    }
}
