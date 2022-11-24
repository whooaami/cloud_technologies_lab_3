package com.database.iot.controller;

import com.database.iot.DTO.MarkOfInterviewDTO;
import com.database.iot.mapper.MarkOfInterviewMapper;
import com.database.iot.model.MarkOfInterview;
import com.database.iot.service.MarkOfInterviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/markOfInterview")

public class MarkOfInterviewController {
    private final MarkOfInterviewService markOfInterviewService;

    @GetMapping
    public List<MarkOfInterviewDTO> getAllMarkOfInterview() {
        return markOfInterviewService.getAllMarkOfInterview().stream().map(MarkOfInterviewMapper::mapMarkOfInterviewToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarkOfInterviewDTO> getMarkOfInterviewById(@PathVariable("id") Integer id) {
        MarkOfInterview markOfInterview = markOfInterviewService.getMarkOfInterviewById(id);
        if (markOfInterview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MarkOfInterviewMapper.mapMarkOfInterviewToDTO(markOfInterview), HttpStatus.OK);
    }

    @PostMapping
    public MarkOfInterviewDTO createMarkOfInterview(@RequestBody MarkOfInterviewDTO markOfInterviewDTO) {
        return MarkOfInterviewMapper.mapMarkOfInterviewToDTO(markOfInterviewService.createMarkOfInterview(markOfInterviewDTO));
    }

    @PutMapping
    public ResponseEntity<MarkOfInterviewDTO> updateMarkOfInterview(@RequestBody MarkOfInterviewDTO markOfInterviewDTO) {
        MarkOfInterview markOfInterview = markOfInterviewService.getMarkOfInterviewById(markOfInterviewDTO.getId());
        if (markOfInterview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MarkOfInterviewMapper.mapMarkOfInterviewToDTO(markOfInterviewService.updateMarkOfInterview(markOfInterviewDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MarkOfInterviewDTO> deleteMarkOfInterview(@PathVariable("id") Integer id) {
        MarkOfInterview markOfInterview = markOfInterviewService.getMarkOfInterviewById(id);
        if (markOfInterview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MarkOfInterviewMapper.mapMarkOfInterviewToDTO(markOfInterviewService.deleteMarkOfInterviewById(id)), HttpStatus.OK
        );
    }
}
