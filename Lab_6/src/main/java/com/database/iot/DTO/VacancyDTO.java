package com.database.iot.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class VacancyDTO {
    private Integer id;
    private String job_desciption;
    private String project_name;
}
