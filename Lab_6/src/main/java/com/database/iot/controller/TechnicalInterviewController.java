package com.database.iot.controller;

import com.database.iot.DTO.TechnicalInterviewDTO;
import com.database.iot.mapper.TechnicalInterviewMapper;
import com.database.iot.model.TechnicalInterview;
import com.database.iot.service.TechnicalInterviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/technicalInterview")

public class TechnicalInterviewController {
    private final TechnicalInterviewService technicalInterviewService;

    @GetMapping
    public List<TechnicalInterviewDTO> getAllTechnicalInterview() {
        return technicalInterviewService.getAllTechnicalInterview().stream().map(TechnicalInterviewMapper::mapTechnicalInterviewToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicalInterviewDTO> getTechnicalInterviewById(@PathVariable("id") Integer id) {
        TechnicalInterview technicalInterview = technicalInterviewService.getTechnicalInterviewById(id);
        if (technicalInterview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                TechnicalInterviewMapper.mapTechnicalInterviewToDTO(technicalInterview), HttpStatus.OK);
    }

    @PostMapping
    public TechnicalInterviewDTO createTechnicalInterview(@RequestBody TechnicalInterviewDTO technicalInterviewDTO) {
        return TechnicalInterviewMapper.mapTechnicalInterviewToDTO(technicalInterviewService.createTechnicalInterview(technicalInterviewDTO));
    }

    @PutMapping
    public ResponseEntity<TechnicalInterviewDTO> updateTechnicalInterview(@RequestBody TechnicalInterviewDTO technicalInterviewDTO) {
        TechnicalInterview technicalInterview = technicalInterviewService.getTechnicalInterviewById(technicalInterviewDTO.getId());
        if (technicalInterview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                TechnicalInterviewMapper.mapTechnicalInterviewToDTO(technicalInterviewService.updateTechnicalInterview(technicalInterviewDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TechnicalInterviewDTO> deleteTechnicalInterview(@PathVariable("id") Integer id) {
        TechnicalInterview technicalInterview = technicalInterviewService.getTechnicalInterviewById(id);
        if (technicalInterview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                TechnicalInterviewMapper.mapTechnicalInterviewToDTO(technicalInterviewService.deleteTechnicalInterviewById(id)), HttpStatus.OK
        );
    }
}
