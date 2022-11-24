package com.database.iot.mapper;

import com.database.iot.DTO.EnglishInterviewDTO;
import com.database.iot.model.EnglishInterview;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class EnglishInterviewMapper {
    public static EnglishInterviewDTO mapEnglishInterviewToDTO(EnglishInterview englishInterview) {
        return new EnglishInterviewDTO(
                englishInterview.getId(),
                englishInterview.getLevel_of_technical(),
                englishInterview.getLevel_of_speaking(),
                englishInterview.getGeneral_level()
        );
    }

    public static EnglishInterview mapDTOToEnglishInterview(EnglishInterviewDTO englishInterviewDTO) {
        return new EnglishInterview(
                englishInterviewDTO.getId(),
                englishInterviewDTO.getLevel_of_technical(),
                englishInterviewDTO.getLevel_of_speaking(),
                englishInterviewDTO.getGeneral_level()
        );
    }
}
