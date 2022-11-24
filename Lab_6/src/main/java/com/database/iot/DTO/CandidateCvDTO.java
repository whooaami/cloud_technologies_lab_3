package com.database.iot.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CandidateCvDTO {
    private Integer id;
    private String job;
    private String work_experience;
    private String place_of_study;
    private String hobby;
    private String skills;
}
