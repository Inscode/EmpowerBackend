package com.backend.empowerpro.service;

import com.backend.empowerpro.dto.applicants.ApplicantsCreationDto;
import com.backend.empowerpro.dto.applicants.ApplicantsDto;

import java.util.List;

public interface ApplicantsService {
    public List<ApplicantsDto> getAllApplicants();
    public String createApplicants(ApplicantsCreationDto applicantsCreationDto);
    public ApplicantsDto getOneApplicant(Long id);
    public ApplicantsDto updateApplicant(Long id,ApplicantsCreationDto applicantsCreationDto);
    public String deleteVacancy(Long id);
}
