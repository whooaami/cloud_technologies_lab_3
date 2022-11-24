package com.database.iot.repository;

import com.database.iot.model.TechnicalInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TechnicalInterviewRepository extends JpaRepository<TechnicalInterview, Integer> {

}
