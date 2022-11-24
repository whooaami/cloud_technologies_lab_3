package com.database.iot.service;

import com.database.iot.DTO.MarkOfInterviewDTO;
import com.database.iot.mapper.MarkOfInterviewMapper;
import com.database.iot.model.MarkOfInterview;
import com.database.iot.repository.MarkOfInterviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class MarkOfInterviewService {
    private final MarkOfInterviewRepository markOfInterviewRepository;

    public List<MarkOfInterview> getAllMarkOfInterview() {
        return markOfInterviewRepository.findAll();
    }

    public MarkOfInterview getMarkOfInterviewById(Integer id) {
        return markOfInterviewRepository.findById(id).orElse(null);
    }

    public MarkOfInterview createMarkOfInterview(MarkOfInterviewDTO markOfInterviewDTO) {
        return markOfInterviewRepository.save(MarkOfInterviewMapper.mapDTOToMarkOfInterview(markOfInterviewDTO));
    }

    public MarkOfInterview updateMarkOfInterview(MarkOfInterviewDTO markOfInterviewDTO) {
        if (getMarkOfInterviewById(markOfInterviewDTO.getId()) != null) {
            return markOfInterviewRepository.save(MarkOfInterviewMapper.mapDTOToMarkOfInterview(markOfInterviewDTO));
        }
        return null;
    }

    public MarkOfInterview deleteMarkOfInterviewById(Integer id) {
        MarkOfInterview markOfInterview = getMarkOfInterviewById(id);
        if (markOfInterview != null) {
            markOfInterviewRepository.deleteById(id);
            return markOfInterview;
        }
        return null;
    }
}
