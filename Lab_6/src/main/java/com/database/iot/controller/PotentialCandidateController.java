package com.database.iot.controller;

import com.database.iot.DTO.PotentialCandidateDTO;
import com.database.iot.mapper.PotentialCandidateMapper;
import com.database.iot.model.PotentialCandidate;
import com.database.iot.service.PotentialCandidateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/potentialCandidate")

public class PotentialCandidateController {
    private final PotentialCandidateService potentialCandidateService;

    @GetMapping
    public List<PotentialCandidateDTO> getAllPotentialCandidate() {
        return potentialCandidateService.getAllPotentialCandidate().stream().map(PotentialCandidateMapper::mapPotentialCandidateToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PotentialCandidateDTO> getPotentialCandidateById(@PathVariable("id") Integer id) {
        PotentialCandidate potentialCandidate = potentialCandidateService.getPotentialCandidateById(id);
        if (potentialCandidate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                PotentialCandidateMapper.mapPotentialCandidateToDTO(potentialCandidate), HttpStatus.OK);
    }

    @PostMapping
    public PotentialCandidateDTO createPotentialCandidate(@RequestBody PotentialCandidateDTO potentialCandidateDTO) {
        return PotentialCandidateMapper.mapPotentialCandidateToDTO(potentialCandidateService.createPotentialCandidate(potentialCandidateDTO));
    }

    @PutMapping
    public ResponseEntity<PotentialCandidateDTO> updatePotentialCandidate(@RequestBody PotentialCandidateDTO potentialCandidateDTO) {
        PotentialCandidate potentialCandidate = potentialCandidateService.getPotentialCandidateById(potentialCandidateDTO.getId());
        if (potentialCandidate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                PotentialCandidateMapper.mapPotentialCandidateToDTO(potentialCandidateService.updatePotentialCandidate(potentialCandidateDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PotentialCandidateDTO> deletePotentialCandidate(@PathVariable("id") Integer id) {
        PotentialCandidate potentialCandidate = potentialCandidateService.getPotentialCandidateById(id);
        if (potentialCandidate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                PotentialCandidateMapper.mapPotentialCandidateToDTO(potentialCandidateService.deletePotentialCandidateById(id)), HttpStatus.OK
        );
    }
}
