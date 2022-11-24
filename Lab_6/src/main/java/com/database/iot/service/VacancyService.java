package com.database.iot.service;

import com.database.iot.DTO.VacancyDTO;
import com.database.iot.mapper.VacancyMapper;
import com.database.iot.model.Vacancy;
import com.database.iot.repository.VacancyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class VacancyService {
    private final VacancyRepository vacancyRepository;

    public List<Vacancy> getAllVacancy() {
        return vacancyRepository.findAll();
    }

    public Vacancy getVacancyById(Integer id) {
        return vacancyRepository.findById(id).orElse(null);
    }

    public Vacancy createVacancy(VacancyDTO vacancyDTO) {
        return vacancyRepository.save(VacancyMapper.mapDTOToVacancy(vacancyDTO));
    }

    public Vacancy updateVacancy(VacancyDTO vacancyDTO) {
        if (getVacancyById(vacancyDTO.getId()) != null) {
            return vacancyRepository.save(VacancyMapper.mapDTOToVacancy(vacancyDTO));
        }
        return null;
    }

    public Vacancy deleteVacancyById(Integer id) {
        Vacancy vacancy = getVacancyById(id);
        if (vacancy != null) {
            vacancyRepository.deleteById(id);
            return vacancy;
        }
        return null;
    }
}
