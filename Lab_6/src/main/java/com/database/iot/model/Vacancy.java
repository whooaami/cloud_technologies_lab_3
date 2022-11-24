package com.database.iot.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vacancy", schema = "mydb")

public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "job_desciption")
    private String job_desciption;
    @Column(name = "project_name")
    private String project_name;
}
