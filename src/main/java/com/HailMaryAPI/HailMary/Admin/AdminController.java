package com.HailMaryAPI.HailMary.Admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:3000")
public class AdminController {
    private final AdminService clientService;

    @Autowired
    public AdminController(AdminService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable("id")Integer id) {
        return clientService.getAdminById(id);
    }

}
