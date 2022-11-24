package com.database.iot.repository;

import com.database.iot.model.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContactPersonRepository extends JpaRepository<ContactPerson, Integer> {
}
