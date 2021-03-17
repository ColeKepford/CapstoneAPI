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

    public Client credentials(String email, String password){
        Optional<Client> clientOptional = clientRepository.findClient(email,password);
        if(clientOptional.isPresent()){
            return clientOptional.get();
        }
        else {
            throw new IllegalStateException("Client doesnt exist");
        }
    }

    public String updateClient(Client client) {
        List<Client> allClients= getAllClients();
        try{
            allClients.stream().filter(e -> e.getClient_id() == client.getClient_id()).forEach(e -> {
                e.setCountry(client.getCountry());
                e.setDob(client.getDob());
                e.setEmail(client.getEmail());
                e.setFirst_name(client.getFirst_name());
                e.setLast_name(client.getLast_name());
                e.setPassword(client.getPassword());
                e.setPhone_number(client.getPhone_number());
                e.setPostal_code(client.getPostal_code());
                e.setProv(client.getProv());
                e.setStreet_address(client.getStreet_address());
            });
        }catch (Exception e) {
            return "Unable to update client";
        }
            return "Update successfull";
    }
}
