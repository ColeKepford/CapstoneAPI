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
        logs.clientRetrievedSuccessfully("Retrieved all clients");
        return clientRepository.findAll();
    }

    public List<Client> getClientsByLastName(String lastName) {
      Optional<List<Client>> clientsOptional = clientRepository.findClientsByLastName(lastName);
      if(clientsOptional.isPresent()) {
        logs.clientRetrievedSuccessfully("Clients with lastname containing: " + lastName + " were retrieved");
            return clientsOptional.get();
      } else {
        logs.clientDoesntExist("Clients with last name containing: " + lastName + " do not exist");
        return null;
      }
    }

    public Client getClientById(int id) {
        boolean exists = clientRepository.existsById(id);
        if(!exists) {
            logs.clientDoesntExist("Client with id: "+id+" doesnt exsist");
            return null;
        }
        else{
            logs.clientRetrievedSuccessfully("Client with id: "+id+" was retrieved");
            return clientRepository.getOne(id);
        }
    }

    public Client getClientByEmail(String email) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(email);
        if(clientOptional.isPresent()) {
            logs.clientRetrievedSuccessfully("Client with email: " + email + " was retrieved");
            return clientOptional.get();
        } else {
            logs.clientDoesntExist("Client with email: " + email + " does not exsist");
            return null;
        }
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());
        if(clientOptional.isPresent()) {
            logs.clientDoesExist("Client with email: " + client.getEmail() + " already exsists");
        }
        clientRepository.save(client);
        logs.clientAddedSuccessfully("Client: " + client.getEmail() + " was successfully added");
    }

    public Client credentials(String email, String password){
        Optional<Client> clientOptional = clientRepository.findClient(email,password);
        if(clientOptional.isPresent()){
            logs.clientRetrievedSuccessfully("Client with email: " + email + " was retrieved");
            return clientOptional.get();
        }
        else {
            logs.clientDoesntExist("Client with email: " + email + " does not exsist");
            return null;
        }
    }

    public void updateClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findById(client.getClient_id());
        if(clientOptional.isPresent()) {
            clientRepository.updateClient(client.getEmail(), client.getFirst_name(), client.getLast_name(), client.getDob(), 
                client.getPhone_number(), client.getStreet_address(), client.getProv(), client.getCountry(),
                client.getPostal_code(), client.getPassword(), client.getClient_id());
         
            logs.updateSuccessful("Client: " + client.getEmail() + " was successfully updated");
        } else {
            logs.unableToUpdateClient("Unable to update client: " + client.getEmail());
        }
    }

    public void deleteClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findById(client.getClient_id());
        if(clientOptional.isPresent()) {
            clientRepository.deleteClient(client.getClient_id());
            logs.clientDeletedSuccessfully("Client: " + client.getEmail() + " was deleted");
        } else {
            logs.unableToDeleteClient("Unable to delete " + client.getEmail());
        }
    }
}