package com.HailMaryAPI.HailMary.Summary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {

    @Query("Select c FROM Summary c WHERE c.client.id = ?1")
    Optional<Summary> findSummary(int client_id);

}
