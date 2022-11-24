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
@Table(name = "potential_candidate", schema = "mydb")

public class PotentialCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone_number")
    private Integer phone_number;
    @Column(name = "email")
    private String email;
    @Column(name = "github")
    private String github;
    @Column(name = "linkedin")
    private String linkedin;
    @Column(name = "candidate_cv_id")
    private Integer candidate_cv_id;
    @Column(name = "english_interview_id")
    private Integer english_interview_id;
    @Column(name = "technical_interview_id")
    private Integer technical_interview_id;
    @Column(name = "mark_of_interview_id")
    private Integer mark_of_interview_id;
}
