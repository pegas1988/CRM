package com.hillel.crm.config.controller.rest;

import com.hillel.crm.config.dto.ClientDto;
import com.hillel.crm.config.entity.Client;
import com.hillel.crm.config.service.impl.ClientServiceRestImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rest/client")
@RequiredArgsConstructor
public class ClientControllerRest {
    private final ClientServiceRestImpl clientServiceRest;

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
        final Client material = clientServiceRest.getById(id);
        ClientDto materialDto = new ClientDto();
        BeanUtils.copyProperties(material, materialDto);
        return new ResponseEntity<>(materialDto, HttpStatus.OK);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDto>> findAll() {
        List<Client> clientList = clientServiceRest.findAll();
        List<ClientDto> clientDtoList = clientList.stream()
                .map(client -> {
                    ClientDto clientDto = new ClientDto();
                    BeanUtils.copyProperties(client, clientDto);
                    return clientDto;
                }).collect(Collectors.toList());
        return new ResponseEntity<>(clientDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto> create(@RequestBody ClientDto clientDto) {
        final Client client = clientServiceRest.create(clientDto);
        clientDto.setClientID(client.getClientID());
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clientServiceRest.delete(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        clientServiceRest.update(id, clientDto);
    }
}
