package com.database.iot.mapper;

import com.database.iot.DTO.MarkOfInterviewDTO;
import com.database.iot.model.MarkOfInterview;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class MarkOfInterviewMapper {
    public static MarkOfInterviewDTO mapMarkOfInterviewToDTO(MarkOfInterview markOfInterview) {
        return new MarkOfInterviewDTO(
                markOfInterview.getId(),
                markOfInterview.getLevel(),
                markOfInterview.getComment_id()
        );
    }

    public static MarkOfInterview mapDTOToMarkOfInterview(MarkOfInterviewDTO markOfInterviewDTO) {
        return new MarkOfInterview(
                markOfInterviewDTO.getId(),
                markOfInterviewDTO.getLevel(),
                markOfInterviewDTO.getComment_id()
        );
    }
}
