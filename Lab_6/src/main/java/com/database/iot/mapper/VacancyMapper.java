package com.database.iot.mapper;

import com.database.iot.DTO.VacancyDTO;
import com.database.iot.model.Vacancy;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class VacancyMapper {

    public static VacancyDTO mapVacancyToDTO(Vacancy vacancy) {
        return new VacancyDTO(
                vacancy.getId(),
                vacancy.getJob_desciption(),
                vacancy.getProject_name()
        );
    }

    public static Vacancy mapDTOToVacancy(VacancyDTO vacancyDTO) {
        return new Vacancy(
                vacancyDTO.getId(),
                vacancyDTO.getJob_desciption(),
                vacancyDTO.getProject_name()
        );
    }

}
