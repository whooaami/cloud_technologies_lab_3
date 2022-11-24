package com.database.iot.service;

import com.database.iot.DTO.CommentDTO;
import com.database.iot.mapper.CommentMapper;
import com.database.iot.model.Comment;
import com.database.iot.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Integer id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment createComment(CommentDTO commentDTO) {
        return commentRepository.save(CommentMapper.mapDTOToComment(commentDTO));
    }

    public Comment updateComment(CommentDTO commentDTO) {
        if (getCommentById(commentDTO.getId()) != null) {
            return commentRepository.save(CommentMapper.mapDTOToComment(commentDTO));
        }
        return null;
    }

    public Comment deleteCommentById(Integer id) {
        Comment comment = getCommentById(id);
        if (comment != null) {
            commentRepository.deleteById(id);
            return comment;
        }
        return null;
    }
}
