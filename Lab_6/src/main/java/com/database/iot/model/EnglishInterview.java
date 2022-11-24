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
@Table(name = "english_interview", schema = "mydb")

public class EnglishInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "level_of_technical")
    private String level_of_technical;
    @Column(name = "level_of_speaking")
    private String level_of_speaking;
    @Column(name = "general_level")
    private String general_level;
}
