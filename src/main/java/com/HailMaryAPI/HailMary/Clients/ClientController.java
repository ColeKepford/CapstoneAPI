package com.HailMaryAPI.HailMary.Clients;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
@CrossOrigin(origins="http://localhost:3000")
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

    @GetMapping(value = "/{id}")
    public Client getClient(@PathVariable("id")Integer id) {
        return clientService.getClientById(id);
    }

    @PostMapping(value = "/addClient")
    public void addNewClient(@RequestBody Client client) {
        clientService.addNewClient(client);
    }

    @GetMapping(value = "/login/{username}&{password}")
    public Client logon(@PathVariable("username") String username,
                      @PathVariable("password") String password) {
        Client cl = clientService.credentials(username, password);
        return cl;
    }

}
