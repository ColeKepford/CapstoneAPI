package com.HailMaryAPI.HailMary.Clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        boolean exists = clientRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Client doesnt exist");
        }
        return clientRepository.getOne(id);
    }


    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());
        if(clientOptional.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }
        clientRepository.save(client);
    }
}
