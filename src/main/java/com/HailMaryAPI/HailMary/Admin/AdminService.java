package com.HailMaryAPI.HailMary.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public Admin getAdminById(int id) {
        boolean exists = adminRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Client doesnt exist");
        }
        return adminRepository.getOne(id);
    }

    public void addNewAdmin(Admin admin) {
        Optional<Admin> adminOptional = adminRepository.findAdminByEmail(admin.getEmail());
        if(adminOptional.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }
        adminRepository.save(admin);
    }

    public Admin credentials(String email, String password){
        Optional<Admin> adminOptional = adminRepository.findAdmin(email,password);
        if(adminOptional.isPresent()){
            return adminOptional.get();
        }
        else {
            throw new IllegalStateException("Admin doesnt exist");
        }
    }
}
