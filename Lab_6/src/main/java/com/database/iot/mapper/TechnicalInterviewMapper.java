package com.database.iot.mapper;

import com.database.iot.DTO.TechnicalInterviewDTO;
import com.database.iot.model.TechnicalInterview;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class TechnicalInterviewMapper {
    public static TechnicalInterviewDTO mapTechnicalInterviewToDTO(TechnicalInterview technicalInterview) {
        return new TechnicalInterviewDTO(
                technicalInterview.getId(),
                technicalInterview.getProgramming_language(),
                technicalInterview.getAlgorithm(),
                technicalInterview.getData_structure(),
                technicalInterview.getDatabase(),
                technicalInterview.getResult_interview()
        );
    }

    public static TechnicalInterview mapDTOToTechnicalInterview(TechnicalInterviewDTO technicalInterviewDTO) {
        return new TechnicalInterview(
                technicalInterviewDTO.getId(),
                technicalInterviewDTO.getProgramming_language(),
                technicalInterviewDTO.getAlgorithm(),
                technicalInterviewDTO.getData_structure(),
                technicalInterviewDTO.getDatabase(),
                technicalInterviewDTO.getResult_interview()
        );
    }
}
