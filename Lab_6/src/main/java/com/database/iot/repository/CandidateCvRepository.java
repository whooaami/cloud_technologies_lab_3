package com.database.iot.repository;

import com.database.iot.model.CandidateCv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CandidateCvRepository extends JpaRepository<CandidateCv, Integer> {

}
