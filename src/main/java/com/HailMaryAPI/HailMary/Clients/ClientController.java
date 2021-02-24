package com.HailMaryAPI.HailMary.Clients;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/clients")
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

    @GetMapping("/{id}")
    public Client getClient(@PathVariable("id")Integer id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/addClient/{email}&{first_name}&{last_name}&{dob}&{phone_number}&{street_address}&{prov}&{country}&{postal_code}&{password}")
    public void addNewClient(@PathVariable("email") String email,
                            @PathVariable("first_name") String first_name,
                            @PathVariable("last_name") String last_name,
                            @PathVariable("dob") String dob,
                            @PathVariable("phone_number") String phone_number,
                            @PathVariable("street_address") String street_address,
                            @PathVariable("prov") String province,
                            @PathVariable("country") String country,
                            @PathVariable("postal_code") String postal_code,
                            @PathVariable("password") String password) {
        //Dont know how HTML formats date
        LocalDate birth = LocalDate.parse(dob);
        Long phone = Long.parseLong(phone_number);
        Client client = new Client(email, first_name, last_name, birth, phone, street_address, 
                                    province, country, postal_code, password);
        clientService.addNewClient(client);
    }

    @GetMapping("/login/{username}&{password}")
    public Client logon(@PathVariable("username") String username,
                      @PathVariable("password") String password) {
        Client cl = clientService.credentials(username, password);
        return cl;
    }

}
