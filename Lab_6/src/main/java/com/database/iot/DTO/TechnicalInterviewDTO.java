package com.database.iot.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class TechnicalInterviewDTO {
    private Integer id;
    private String programming_language;
    private String algorithm;
    private String data_structure;
    private String database;
    private String result_interview;
}
