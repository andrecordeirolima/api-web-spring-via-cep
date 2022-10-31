package com.andrecordeirolima.apiwebspring.service;

import com.andrecordeirolima.apiwebspring.model.Client;

public interface ClientService {

    Iterable<Client> findAll();
    Client findById(Long id);
    void insert(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}
