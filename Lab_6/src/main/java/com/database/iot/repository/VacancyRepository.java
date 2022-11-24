package com.database.iot.repository;

import com.database.iot.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {

}
