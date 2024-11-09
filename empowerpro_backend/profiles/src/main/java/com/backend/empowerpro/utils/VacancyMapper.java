package com.backend.empowerpro.utils;

import com.backend.empowerpro.dto.vacancy.VacancyCreationDto;
import com.backend.empowerpro.dto.vacancy.VacancyDto;
import com.backend.empowerpro.entity.Vacancy;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface VacancyMapper {
    VacancyDto toVacancyDto(Vacancy vacancy);
    Vacancy toVacancy(VacancyCreationDto vacancyCreationDto);
}
