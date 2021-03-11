package com.HailMaryAPI.HailMary.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query("SELECT c FROM Admin c WHERE c.email = ?1")
    Optional<Admin> findAdminByEmail(String email);

    @Query("Select c FROM Admin c WHERE c.email = ?1 AND c.password = ?2")
    Optional<Admin> findAdmin(String email, String password);

}
