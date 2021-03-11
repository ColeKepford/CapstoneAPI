package com.HailMaryAPI.HailMary.Admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:3000")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable("id")Integer id) {
        return adminService.getAdminById(id);
    }

    @GetMapping("/login/{username}&{password}")
    public Admin logon(@PathVariable("username") String username,
                      @PathVariable("password") String password) {
        Admin cl = adminService.credentials(username, password);
        return cl;
    }

    @PostMapping(path="/registerAdmin", consumes = "application/json", produces = "application/json")
    public void addNewAdmin(@RequestBody Admin admin) {
        adminService.addNewAdmin(admin);
    }
}
