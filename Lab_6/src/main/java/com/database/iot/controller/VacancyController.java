package com.database.iot.controller;

import com.database.iot.DTO.VacancyDTO;
import com.database.iot.mapper.VacancyMapper;
import com.database.iot.model.Vacancy;
import com.database.iot.service.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/vacancy")

public class VacancyController {
    private final VacancyService vacancyService;

    @GetMapping
    public List<VacancyDTO> getAllVacancy() {
        return vacancyService.getAllVacancy().stream().map(VacancyMapper::mapVacancyToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacancyDTO> getVacancyById(@PathVariable("id") Integer id) {
        Vacancy vacancy = vacancyService.getVacancyById(id);
        if (vacancy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                VacancyMapper.mapVacancyToDTO(vacancy), HttpStatus.OK);
    }

    @PostMapping
    public VacancyDTO createVacancy(@RequestBody VacancyDTO vacancyDTO) {
        return VacancyMapper.mapVacancyToDTO(vacancyService.createVacancy(vacancyDTO));
    }

    @PutMapping
    public ResponseEntity<VacancyDTO> updateVacancy(@RequestBody VacancyDTO vacancyDTO) {
        Vacancy vacancy = vacancyService.getVacancyById(vacancyDTO.getId());
        if (vacancy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                VacancyMapper.mapVacancyToDTO(vacancyService.updateVacancy(vacancyDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<VacancyDTO> deleteVacancy(@PathVariable("id") Integer id) {
        Vacancy vacancy = vacancyService.getVacancyById(id);
        if (vacancy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                VacancyMapper.mapVacancyToDTO(vacancyService.deleteVacancyById(id)), HttpStatus.OK
        );
    }
}
