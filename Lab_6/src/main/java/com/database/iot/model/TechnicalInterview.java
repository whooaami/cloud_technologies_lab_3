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
@Table(name = "technical_interview", schema = "mydb")

public class TechnicalInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "programming_language")
    private String programming_language;
    @Column(name = "algorithm")
    private String algorithm;
    @Column(name = "data_structure")
    private String data_structure;
    @Column(name = "database")
    private String database;
    @Column(name = "result_interview")
    private String result_interview;
}
