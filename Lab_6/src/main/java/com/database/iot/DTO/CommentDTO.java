package com.database.iot.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CommentDTO {
    private Integer id;
    private Integer rating;
    private String response;
}
