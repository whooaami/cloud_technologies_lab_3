package com.database.iot.mapper;

import com.database.iot.DTO.PotentialCandidateDTO;
import com.database.iot.model.PotentialCandidate;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class PotentialCandidateMapper {

    public static PotentialCandidateDTO mapPotentialCandidateToDTO(PotentialCandidate potentialCandidate) {
        return new PotentialCandidateDTO(
                potentialCandidate.getId(),
                potentialCandidate.getName(),
                potentialCandidate.getSurname(),
                potentialCandidate.getPhone_number(),
                potentialCandidate.getEmail(),
                potentialCandidate.getGithub(),
                potentialCandidate.getLinkedin(),
                potentialCandidate.getCandidate_cv_id(),
                potentialCandidate.getEnglish_interview_id(),
                potentialCandidate.getTechnical_interview_id(),
                potentialCandidate.getMark_of_interview_id()
        );
    }

    public static PotentialCandidate mapDTOToPotentialCandidate(PotentialCandidateDTO potentialCandidateDTO) {
        return new PotentialCandidate(
                potentialCandidateDTO.getId(),
                potentialCandidateDTO.getName(),
                potentialCandidateDTO.getSurname(),
                potentialCandidateDTO.getPhone_number(),
                potentialCandidateDTO.getEmail(),
                potentialCandidateDTO.getGithub(),
                potentialCandidateDTO.getLinkedin(),
                potentialCandidateDTO.getCandidate_cv_id(),
                potentialCandidateDTO.getEnglish_interview_id(),
                potentialCandidateDTO.getTechnical_interview_id(),
                potentialCandidateDTO.getMark_of_interview_id()
        );
    }

}
