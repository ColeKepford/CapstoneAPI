package com.HailMaryAPI.HailMary.Policies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import javax.transaction.Transactional;

import com.HailMaryAPI.HailMary.Clients.Client;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {
    
    @Query("SELECT c FROM Policy c WHERE c.client.email= ?1")
    Optional<List<Policy>> findPoliciesByEmail(String email);

    @Query("SELECT c FROM Policy c WHERE c.client.id= ?1")
    Optional<List<Policy>> findPoliciesByClientId(int id);

    @Query("Select c FROM Policy c WHERE c.first_name = ?1 AND c.last_name = ?2")
    Optional<List<Policy>> findByName(String first_name, String last_name);

    @Transactional
    @Modifying
    @Query("UPDATE Policy SET client = ?1, policy_number= ?2, first_name = ?3, last_name = ?4, provider = ?5, type = ?6, coverage_amount = ?7, start_date = ?8, end_date = ?9 WHERE policy_id = ?10")
    void updatePolicy(Client client, String policy_number, String first_name, String last_name,
                                    String provider, String type, double coverage_amount, LocalDate start_date, LocalDate end_date,
                                    int id);

                                    @Transactional
    @Modifying
    @Query("DELETE FROM Policy WHERE policy_id=?1")
    void deletePolicy(int id);
}
