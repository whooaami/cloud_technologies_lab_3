package com.database.iot.service;

import com.database.iot.DTO.EnglishInterviewDTO;
import com.database.iot.mapper.EnglishInterviewMapper;
import com.database.iot.model.EnglishInterview;
import com.database.iot.repository.EnglishInterviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class EnglishInterviewService {
    private final EnglishInterviewRepository englishInterviewRepository;

    public List<EnglishInterview> getAllEnglishInterview() {
        return englishInterviewRepository.findAll();
    }

    public EnglishInterview getEnglishInterviewById(Integer id) {
        return englishInterviewRepository.findById(id).orElse(null);
    }

    public EnglishInterview createEnglishInterview(EnglishInterviewDTO englishInterviewDTO) {
        return englishInterviewRepository.save(EnglishInterviewMapper.mapDTOToEnglishInterview(englishInterviewDTO));
    }

    public EnglishInterview updateEnglishInterview(EnglishInterviewDTO englishInterviewDTO) {
        if (getEnglishInterviewById(englishInterviewDTO.getId()) != null) {
            return englishInterviewRepository.save(EnglishInterviewMapper.mapDTOToEnglishInterview(englishInterviewDTO));
        }
        return null;
    }

    public EnglishInterview deleteEnglishInterviewById(Integer id) {
        EnglishInterview englishInterview = getEnglishInterviewById(id);
        if (englishInterview != null) {
            englishInterviewRepository.deleteById(id);
            return englishInterview;
        }
        return null;
    }
}
