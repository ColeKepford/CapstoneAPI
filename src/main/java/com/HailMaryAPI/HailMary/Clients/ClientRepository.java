package com.HailMaryAPI.HailMary.Clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c WHERE c.email = ?1")
    Optional<Client> findClientByEmail(String email);

    @Query("Select c FROM Client c WHERE c.email = ?1 AND c.password = ?2")
    Optional<Client> findClient(String email, String password);

    @Query("Select c FROM Client c WHERE c.last_name LIKE ?1%")
    Optional<List<Client>> findClientsByLastName(String lastName);

    @Transactional
    @Modifying
    @Query("UPDATE Client SET email = ?1, first_name = ?2, last_name = ?3, date_of_birth = ?4, phone_number = ?5, street_address = ?6, province = ?7, country = ?8, postal_code = ?9, password = ?10 WHERE client_id = ?11")
    void updateClient(String email, String first_name, String last_name, String date_of_birth,
                                    Long phone_number, String street_address, String province, String country,
                                    String postal_code, String password, int id);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Client WHERE client_id=?1")
    void deleteClient(int id);
}
