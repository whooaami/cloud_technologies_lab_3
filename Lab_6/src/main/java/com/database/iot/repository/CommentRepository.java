package com.database.iot.repository;

import com.database.iot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
