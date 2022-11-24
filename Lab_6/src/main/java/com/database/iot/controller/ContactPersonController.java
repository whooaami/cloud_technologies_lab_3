package com.database.iot.controller;

import com.database.iot.DTO.ContactPersonDTO;
import com.database.iot.mapper.ContactPersonMapper;
import com.database.iot.model.ContactPerson;
import com.database.iot.service.ContactPersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/contactPerson")

public class ContactPersonController {
    private final ContactPersonService contactPersonService;

    @GetMapping
    public List<ContactPersonDTO> getAllContactPerson() {
        return contactPersonService.getAllContactPerson().stream().map(ContactPersonMapper::mapContactPersonToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactPersonDTO> getContactPersonById(@PathVariable("id") Integer id) {
        ContactPerson contactPerson = contactPersonService.getContactPersonById(id);
        if (contactPerson == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ContactPersonMapper.mapContactPersonToDTO(contactPerson), HttpStatus.OK);
    }

    @PostMapping
    public ContactPersonDTO createContactPerson(@RequestBody ContactPersonDTO contactPersonDTO) {
        return ContactPersonMapper.mapContactPersonToDTO(contactPersonService.createContactPerson(contactPersonDTO));
    }

    @PutMapping
    public ResponseEntity<ContactPersonDTO> updateContactPerson(@RequestBody ContactPersonDTO contactPersonDTO) {
        ContactPerson contactPerson = contactPersonService.getContactPersonById(contactPersonDTO.getId());
        if (contactPerson == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ContactPersonMapper.mapContactPersonToDTO(contactPersonService.updateContactPerson(contactPersonDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ContactPersonDTO> deleteContactPerson(@PathVariable("id") Integer id) {
        ContactPerson contactPerson = contactPersonService.getContactPersonById(id);
        if (contactPerson == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ContactPersonMapper.mapContactPersonToDTO(contactPersonService.deleteContactPersonById(id)), HttpStatus.OK
        );
    }
}
