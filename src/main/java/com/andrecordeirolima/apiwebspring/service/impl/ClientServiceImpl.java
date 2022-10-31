package com.andrecordeirolima.apiwebspring.service.impl;

import com.andrecordeirolima.apiwebspring.model.Address;
import com.andrecordeirolima.apiwebspring.model.Client;
import com.andrecordeirolima.apiwebspring.repository.AddressRepository;
import com.andrecordeirolima.apiwebspring.repository.ClientRepository;
import com.andrecordeirolima.apiwebspring.service.ClientService;
import com.andrecordeirolima.apiwebspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClientWithZipCode(client);

    }



    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientDb = clientRepository.findById(id);
        if (clientDb.isPresent()) {
            saveClientWithZipCode(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithZipCode(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.consultCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);

        clientRepository.save(client);
    }
}
