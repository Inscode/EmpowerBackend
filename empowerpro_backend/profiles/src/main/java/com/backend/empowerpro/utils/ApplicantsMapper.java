package com.backend.empowerpro.utils;


import com.backend.empowerpro.dto.accounts.AccountsCreationDto;
import com.backend.empowerpro.dto.accounts.AccountsDto;
import com.backend.empowerpro.dto.applicants.ApplicantsCreationDto;
import com.backend.empowerpro.dto.applicants.ApplicantsDto;
import com.backend.empowerpro.entity.Accounts;
import com.backend.empowerpro.entity.Applicants;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicantsMapper {
    ApplicantsDto toApplicantsDto(Applicants applicants);
    Applicants toApplicants(ApplicantsCreationDto applicantsCreationDto);
}
