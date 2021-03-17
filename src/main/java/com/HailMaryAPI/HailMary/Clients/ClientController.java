package com.HailMaryAPI.HailMary.Clients;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.HailMaryAPI.HailMary.Email.Email;
import com.HailMaryAPI.HailMary.Email.SendEmailService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins="http://localhost:3000")
public class ClientController {
    private final ClientService clientService;
    private final SendEmailService sendEmailService;

    @Autowired
    public ClientController(ClientService clientService, SendEmailService sendEmailService) {
        this.clientService = clientService;
        this.sendEmailService = sendEmailService;
    }

    @GetMapping("/allClients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/id/{id}")
    public Client getClient(@PathVariable("id")Integer id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/clientemail/{email}")
    public Client getClientByEmail(@PathVariable String email) {
        return clientService.getClientByEmail(email);;
    }

    @PostMapping(path="/registerClient", consumes = "application/json", produces = "application/json")
    public void addNewClient(@RequestBody Client client) {
        clientService.addNewClient(client);
    }

    @GetMapping("/login/{username}&{password}")
    public Client logon(@PathVariable("username") String username,
                      @PathVariable("password") String password) {
        return clientService.credentials(username, password);
    }

    @PostMapping(path="/sendEmail", consumes = "application/json", produces = "application/json")
    public void sendEmail(@RequestBody Email email) {
        this.sendEmailService.sendEmail(email);
    }

    @PutMapping("/update")
    public void updateClient(@RequestBody Client client) {
       clientService.updateClient(client);
    }
}
