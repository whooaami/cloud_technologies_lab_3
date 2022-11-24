package com.database.iot.repository;

import com.database.iot.model.MarkOfInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MarkOfInterviewRepository extends JpaRepository<MarkOfInterview, Integer> {

}
