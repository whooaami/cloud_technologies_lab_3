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
@Table(name = "comment", schema = "mydb")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "response")
    private String response;
}
