package com.HailMaryAPI.HailMary.Clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c WHERE c.email = ?1")
    Optional<Client> findClientByEmail(String email);

    @Query("Select c FROM Client c WHERE c.email = ?1 AND c.password = ?2")
    Optional<Client> findClient(String email, String password);

}
