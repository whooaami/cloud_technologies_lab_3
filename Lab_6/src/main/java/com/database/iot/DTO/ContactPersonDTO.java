package com.database.iot.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ContactPersonDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer phone_number;
}
