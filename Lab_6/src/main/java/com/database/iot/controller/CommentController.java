package com.database.iot.controller;

import com.database.iot.DTO.CommentDTO;
import com.database.iot.mapper.CommentMapper;
import com.database.iot.model.Comment;
import com.database.iot.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/comment")

public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<CommentDTO> getAllComment() {
        return commentService.getAllComment().stream().map(CommentMapper::mapCommentToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable("id") Integer id) {
        Comment comment = commentService.getCommentById(id);
        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CommentMapper.mapCommentToDTO(comment), HttpStatus.OK);
    }

    @PostMapping
    public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
        return CommentMapper.mapCommentToDTO(commentService.createComment(commentDTO));
    }

    @PutMapping
    public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO commentDTO) {
        Comment comment = commentService.getCommentById(commentDTO.getId());
        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CommentMapper.mapCommentToDTO(commentService.updateComment(commentDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDTO> deleteComment(@PathVariable("id") Integer id) {
        Comment comment = commentService.getCommentById(id);
        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CommentMapper.mapCommentToDTO(commentService.deleteCommentById(id)), HttpStatus.OK
        );
    }
}
