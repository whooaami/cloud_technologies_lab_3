package com.database.iot.repository;

import com.database.iot.model.PotentialCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PotentialCandidateRepository extends JpaRepository<PotentialCandidate, Integer> {

}
