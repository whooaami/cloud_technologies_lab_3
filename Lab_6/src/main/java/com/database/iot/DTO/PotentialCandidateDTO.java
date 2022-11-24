package com.database.iot.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class PotentialCandidateDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer phone_number;
    private String email;
    private String github;
    private String linkedin;
    private Integer candidate_cv_id;
    private Integer english_interview_id;
    private Integer technical_interview_id;
    private Integer mark_of_interview_id;
}
