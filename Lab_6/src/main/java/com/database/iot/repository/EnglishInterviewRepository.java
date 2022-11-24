package com.database.iot.repository;

import com.database.iot.model.EnglishInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EnglishInterviewRepository extends JpaRepository<EnglishInterview, Integer> {

}
