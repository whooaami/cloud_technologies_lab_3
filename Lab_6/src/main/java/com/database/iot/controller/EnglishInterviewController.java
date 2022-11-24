package com.database.iot.controller;


import com.database.iot.DTO.EnglishInterviewDTO;
import com.database.iot.mapper.EnglishInterviewMapper;
import com.database.iot.model.EnglishInterview;
import com.database.iot.service.EnglishInterviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/englishInterview")

public class EnglishInterviewController {
    private final EnglishInterviewService englishInterviewService;

    @GetMapping
    public List<EnglishInterviewDTO> getAllEnglishInterview() {
        return englishInterviewService.getAllEnglishInterview().stream().map(EnglishInterviewMapper::mapEnglishInterviewToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnglishInterviewDTO> getEnglishInterviewById(@PathVariable("id") Integer id) {
        EnglishInterview englishInterview = englishInterviewService.getEnglishInterviewById(id);
        if (englishInterview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                EnglishInterviewMapper.mapEnglishInterviewToDTO(englishInterview), HttpStatus.OK);
    }

    @PostMapping
    public EnglishInterviewDTO createEnglishInterview(@RequestBody EnglishInterviewDTO englishInterviewDTO) {
        return EnglishInterviewMapper.mapEnglishInterviewToDTO(englishInterviewService.createEnglishInterview(englishInterviewDTO));
    }

    @PutMapping
    public ResponseEntity<EnglishInterviewDTO> updateEnglishInterview(@RequestBody EnglishInterviewDTO englishInterviewDTO) {
        EnglishInterview englishInterview = englishInterviewService.getEnglishInterviewById(englishInterviewDTO.getId());
        if (englishInterview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                EnglishInterviewMapper.mapEnglishInterviewToDTO(englishInterviewService.updateEnglishInterview(englishInterviewDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<EnglishInterviewDTO> deleteEnglishInterview(@PathVariable("id") Integer id) {
        EnglishInterview englishInterview = englishInterviewService.getEnglishInterviewById(id);
        if (englishInterview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                EnglishInterviewMapper.mapEnglishInterviewToDTO(englishInterviewService.deleteEnglishInterviewById(id)), HttpStatus.OK
        );
    }
}
