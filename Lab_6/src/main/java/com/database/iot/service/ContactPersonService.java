package com.database.iot.service;

import com.database.iot.DTO.ContactPersonDTO;
import com.database.iot.mapper.ContactPersonMapper;
import com.database.iot.model.ContactPerson;
import com.database.iot.repository.ContactPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class ContactPersonService {
    private final ContactPersonRepository contactPersonRepository;

    public List<ContactPerson> getAllContactPerson() {
        return contactPersonRepository.findAll();
    }

    public ContactPerson getContactPersonById(Integer id) {
        return contactPersonRepository.findById(id).orElse(null);
    }

    public ContactPerson createContactPerson(ContactPersonDTO contactPersonDTO) {
        return contactPersonRepository.save(ContactPersonMapper.mapDTOToContactPerson(contactPersonDTO));
    }

    public ContactPerson updateContactPerson(ContactPersonDTO contactPersonDTO) {
        if (getContactPersonById(contactPersonDTO.getId()) != null) {
            return contactPersonRepository.save(ContactPersonMapper.mapDTOToContactPerson(contactPersonDTO));
        }
        return null;
    }

    public ContactPerson deleteContactPersonById(Integer id) {
        ContactPerson contactPerson = getContactPersonById(id);
        if (contactPerson != null) {
            contactPersonRepository.deleteById(id);
            return contactPerson;
        }
        return null;
    }
}
