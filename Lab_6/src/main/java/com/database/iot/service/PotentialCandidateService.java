package com.database.iot.service;

import com.database.iot.DTO.PotentialCandidateDTO;
import com.database.iot.mapper.PotentialCandidateMapper;
import com.database.iot.model.PotentialCandidate;
import com.database.iot.repository.PotentialCandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class PotentialCandidateService {
    private final PotentialCandidateRepository potentialCandidateRepository;

    public List<PotentialCandidate> getAllPotentialCandidate() {
        return potentialCandidateRepository.findAll();
    }

    public PotentialCandidate getPotentialCandidateById(Integer id) {
        return potentialCandidateRepository.findById(id).orElse(null);
    }

    public PotentialCandidate createPotentialCandidate(PotentialCandidateDTO potentialCandidateDTO) {
        return potentialCandidateRepository.save(PotentialCandidateMapper.mapDTOToPotentialCandidate(potentialCandidateDTO));
    }

    public PotentialCandidate updatePotentialCandidate(PotentialCandidateDTO potentialCandidateDTO) {
        if (getPotentialCandidateById(potentialCandidateDTO.getId()) != null) {
            return potentialCandidateRepository.save(PotentialCandidateMapper.mapDTOToPotentialCandidate(potentialCandidateDTO));
        }
        return null;
    }

    public PotentialCandidate deletePotentialCandidateById(Integer id) {
        PotentialCandidate potentialCandidate = getPotentialCandidateById(id);
        if (potentialCandidate != null) {
            potentialCandidateRepository.deleteById(id);
            return potentialCandidate;
        }
        return null;
    }
}
