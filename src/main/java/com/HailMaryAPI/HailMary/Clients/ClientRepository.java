package com.HailMaryAPI.HailMary.Clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findAll();
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Client> findClientByEmail(String email);
}
