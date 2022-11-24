package com.database.iot.service;

import com.database.iot.DTO.TechnicalInterviewDTO;
import com.database.iot.mapper.TechnicalInterviewMapper;
import com.database.iot.model.TechnicalInterview;
import com.database.iot.repository.TechnicalInterviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class TechnicalInterviewService {
    private final TechnicalInterviewRepository technicalInterviewRepository;

    public List<TechnicalInterview> getAllTechnicalInterview() {
        return technicalInterviewRepository.findAll();
    }

    public TechnicalInterview getTechnicalInterviewById(Integer id) {
        return technicalInterviewRepository.findById(id).orElse(null);
    }

    public TechnicalInterview createTechnicalInterview(TechnicalInterviewDTO technicalInterviewDTO) {
        return technicalInterviewRepository.save(TechnicalInterviewMapper.mapDTOToTechnicalInterview(technicalInterviewDTO));
    }

    public TechnicalInterview updateTechnicalInterview(TechnicalInterviewDTO technicalInterviewDTO) {
        if (getTechnicalInterviewById(technicalInterviewDTO.getId()) != null) {
            return technicalInterviewRepository.save(TechnicalInterviewMapper.mapDTOToTechnicalInterview(technicalInterviewDTO));
        }
        return null;
    }

    public TechnicalInterview deleteTechnicalInterviewById(Integer id) {
        TechnicalInterview technicalInterview = getTechnicalInterviewById(id);
        if (technicalInterview != null) {
            technicalInterviewRepository.deleteById(id);
            return technicalInterview;
        }
        return null;
    }
}
