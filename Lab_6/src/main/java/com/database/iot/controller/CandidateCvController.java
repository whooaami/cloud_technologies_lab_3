package com.database.iot.controller;

import com.database.iot.DTO.CandidateCvDTO;
import com.database.iot.mapper.CandidateCvMapper;
import com.database.iot.model.CandidateCv;
import com.database.iot.service.CandidateCvService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/candidateCv")

public class CandidateCvController {
    private final CandidateCvService candidateCvService;

    @GetMapping
    public List<CandidateCvDTO> getAllCandidateCv() {
        return candidateCvService.getAllCandidateCv().stream().map(CandidateCvMapper::mapCandidateCvToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateCvDTO> getCandidateCvById(@PathVariable("id") Integer id) {
        CandidateCv candidateCv = candidateCvService.getCandidateCvById(id);
        if (candidateCv == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CandidateCvMapper.mapCandidateCvToDTO(candidateCv), HttpStatus.OK);
    }

    @PostMapping
    public CandidateCvDTO createCandidateCv(@RequestBody CandidateCvDTO candidateCvDTO) {
        return CandidateCvMapper.mapCandidateCvToDTO(candidateCvService.createCandidateCv(candidateCvDTO));
    }

    @PutMapping
    public ResponseEntity<CandidateCvDTO> updateCandidateCv(@RequestBody CandidateCvDTO candidateCvDTO) {
        CandidateCv candidateCv = candidateCvService.getCandidateCvById(candidateCvDTO.getId());
        if (candidateCv == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CandidateCvMapper.mapCandidateCvToDTO(candidateCvService.updateCandidateCv(candidateCvDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CandidateCvDTO> deleteCandidateCv(@PathVariable("id") Integer id) {
        CandidateCv candidateCv = candidateCvService.getCandidateCvById(id);
        if (candidateCv == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CandidateCvMapper.mapCandidateCvToDTO(candidateCvService.deleteCandidateCvById(id)), HttpStatus.OK
        );
    }
}
