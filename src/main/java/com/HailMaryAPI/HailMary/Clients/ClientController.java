package com.HailMaryAPI.HailMary.Clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable("id")Integer id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public void addNewClient(@RequestBody Client client) {
        clientService.addNewClient(client);
    }
}
