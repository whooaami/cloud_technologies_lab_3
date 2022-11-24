package com.database.iot.service;

import com.database.iot.DTO.CandidateCvDTO;
import com.database.iot.mapper.CandidateCvMapper;
import com.database.iot.model.CandidateCv;
import com.database.iot.repository.CandidateCvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class CandidateCvService {
    private final CandidateCvRepository candidateCvRepository;

    public List<CandidateCv> getAllCandidateCv() {
        return candidateCvRepository.findAll();
    }

    public CandidateCv getCandidateCvById(Integer id) {
        return candidateCvRepository.findById(id).orElse(null);
    }

    public CandidateCv createCandidateCv(CandidateCvDTO candidateCvDTO) {
        return candidateCvRepository.save(CandidateCvMapper.mapDTOToCandidateCv(candidateCvDTO));
    }

    public CandidateCv updateCandidateCv(CandidateCvDTO candidateCvDTO) {
        if (getCandidateCvById(candidateCvDTO.getId()) != null) {
            return candidateCvRepository.save(CandidateCvMapper.mapDTOToCandidateCv(candidateCvDTO));
        }
        return null;
    }

    public CandidateCv deleteCandidateCvById(Integer id) {
        CandidateCv candidateCv = getCandidateCvById(id);
        if (candidateCv != null) {
            candidateCvRepository.deleteById(id);
            return candidateCv;
        }
        return null;
    }
}
