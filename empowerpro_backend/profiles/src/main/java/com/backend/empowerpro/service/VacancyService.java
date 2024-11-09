package com.backend.empowerpro.service;

import com.backend.empowerpro.dto.vacancy.VacancyCreationDto;
import com.backend.empowerpro.dto.vacancy.VacancyDto;

import java.util.List;

public interface VacancyService {
    public List<VacancyDto> getAllVacancies();
    public String createVacancy(VacancyCreationDto vacancyCreationDto);
    public VacancyDto getOneVacancy(Long id);
    public VacancyDto updateVacancy(Long id,VacancyCreationDto vacancyCreationDto);
    public String deleteVacancy(Long id);
    public long getVacancyCount();

}
