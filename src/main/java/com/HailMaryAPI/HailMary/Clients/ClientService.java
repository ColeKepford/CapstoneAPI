package com.HailMaryAPI.HailMary.Clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.HailMaryAPI.HailMary.Logging.LoggingController;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final LoggingController logs;

    @Autowired
    public ClientService(ClientRepository clientRepository, LoggingController logs) {
        this.clientRepository = clientRepository;
        this.logs = logs;
    }

    public List<Client> getAllClients() {
        logs.clientRetrivedSuccessfully();
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        boolean exists = clientRepository.existsById(id);
        if(!exists) {
            logs.clientDoesntExist();
            return null;
        }
        else{
            logs.clientRetrivedSuccessfully();
            return clientRepository.getOne(id);
        }
    }

    public Client getClientByEmail(String email) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(email);
        if(clientOptional.isPresent()) {
            logs.clientRetrivedSuccessfully();
            return clientOptional.get();
        } else {
            logs.clientDoesntExist();
            return null;
        }
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());
        if(clientOptional.isPresent()) {
            logs.clientDoesExist();
        }
        clientRepository.save(client);
        logs.clientAddedSuccessfully();
    }

    public Client credentials(String email, String password){
        Optional<Client> clientOptional = clientRepository.findClient(email,password);
        if(clientOptional.isPresent()){
            logs.clientRetrivedSuccessfully();
            return clientOptional.get();
        }
        else {
            logs.clientDoesntExist();
            return null;
        }
    }

    public void updateClient(Client client) {
        clientRepository.updateClient(client.getEmail(), client.getFirst_name(), client.getLast_name(), client.getDob(), 
        client.getPhone_number(), client.getStreet_address(), client.getProv(), client.getCountry(),
         client.getPostal_code(), client.getPassword(), client.getClient_id());
        
    }
}