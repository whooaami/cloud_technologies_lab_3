package com.database.iot.mapper;

import com.database.iot.DTO.ContactPersonDTO;
import com.database.iot.model.ContactPerson;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class ContactPersonMapper {

    public static ContactPersonDTO mapContactPersonToDTO(ContactPerson contactPerson) {
        return new ContactPersonDTO(
                contactPerson.getId(),
                contactPerson.getName(),
                contactPerson.getSurname(),
                contactPerson.getPhone_number()
        );
    }

    public static ContactPerson mapDTOToContactPerson(ContactPersonDTO contactPersonDTO) {
        return new ContactPerson(
                contactPersonDTO.getId(),
                contactPersonDTO.getName(),
                contactPersonDTO.getSurname(),
                contactPersonDTO.getPhone_number()
        );
    }

}
