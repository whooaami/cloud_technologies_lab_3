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
@Table(name = "candidate_cv", schema = "mydb")

public class CandidateCv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "job")
    private String job;
    @Column(name = "work_experience")
    private String work_experience;
    @Column(name = "place_of_study")
    private String place_of_study;
    @Column(name = "hobby")
    private String hobby;
    @Column(name = "skills")
    private String skills;
}
