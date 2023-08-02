package com.omar.gestiondestock.controller;

import com.omar.gestiondestock.controller.api.ClientApi;
import com.omar.gestiondestock.dto.ClientDto;
import com.omar.gestiondestock.service.ClientService;

import java.util.List;

public class ClientController implements ClientApi {

    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;

    }

    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
