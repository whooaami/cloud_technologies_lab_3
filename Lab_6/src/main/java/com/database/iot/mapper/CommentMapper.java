package com.database.iot.mapper;

import com.database.iot.DTO.CommentDTO;
import com.database.iot.model.Comment;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class CommentMapper {

    public static CommentDTO mapCommentToDTO(Comment comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getRating(),
                comment.getResponse()
        );
    }

    public static Comment mapDTOToComment(CommentDTO commentDTO) {
        return new Comment(
                commentDTO.getId(),
                commentDTO.getRating(),
                commentDTO.getResponse()
        );
    }

}
