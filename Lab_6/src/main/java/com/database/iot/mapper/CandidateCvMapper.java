package com.database.iot.mapper;

import com.database.iot.DTO.CandidateCvDTO;
import com.database.iot.model.CandidateCv;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class CandidateCvMapper {

    public static CandidateCvDTO mapCandidateCvToDTO(CandidateCv candidateCv) {
        return new CandidateCvDTO(
                candidateCv.getId(),
                candidateCv.getJob(),
                candidateCv.getWork_experience(),
                candidateCv.getPlace_of_study(),
                candidateCv.getHobby(),
                candidateCv.getSkills()
        );
    }

    public static CandidateCv mapDTOToCandidateCv(CandidateCvDTO candidateCvDTO) {
        return new CandidateCv(
                candidateCvDTO.getId(),
                candidateCvDTO.getJob(),
                candidateCvDTO.getWork_experience(),
                candidateCvDTO.getPlace_of_study(),
                candidateCvDTO.getHobby(),
                candidateCvDTO.getSkills()
        );
    }

}
