package com.backend.empowerpro.service.impl;

import com.backend.empowerpro.dto.vacancy.VacancyCreationDto;
import com.backend.empowerpro.dto.vacancy.VacancyDto;
import com.backend.empowerpro.entity.Vacancy;
import com.backend.empowerpro.exception.VacancyNotFoundException;
import com.backend.empowerpro.repository.VacancyRepo;
import com.backend.empowerpro.service.VacancyService;
import com.backend.empowerpro.utils.VacancyMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacancyServiceImp implements VacancyService {
    private static final Logger logger = LoggerFactory.getLogger(Vacancy.class);
    private final VacancyRepo vacancyRepo;
    private final VacancyMapper vacancyMapper;
    @Override
    public List<VacancyDto> getAllVacancies() {
        try{
            //Fetching All Vacancies
            List<Vacancy> allVacancies = vacancyRepo.findAll();
            logger.info("All Vacancies has been Fetched Successfully");
            //Mapping All Vacancies to result List
            return allVacancies.stream()
                    .map(vacancyMapper::toVacancyDto)
                    .collect(Collectors.toList());
            } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching vacancies: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching vacancies", e);
        }
    }

    @Override
    public String createVacancy(VacancyCreationDto vacancyCreationDto) {
        try{
            Vacancy vacancy = vacancyMapper.toVacancy(vacancyCreationDto);
            vacancyRepo.save(vacancy);
            logger.info("Vacancies has been created Successfully {}",vacancy);
            return "Successfully Created";
        }catch (Exception e){
            logger.error("An unexpected error occurred while creating vacancy: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while creating vacancy", e);
        }
    }

    @Override
    public VacancyDto getOneVacancy(Long id) {
        try{
            //Fetching All Vacancies
            Optional<Vacancy> vacancy = vacancyRepo.findById(id);
            if(vacancy.isPresent()){
                Vacancy vacancyResult = vacancy.get();
                logger.info("vacancy of {} has been fetched Successfully", id);
                return vacancyMapper.toVacancyDto(vacancyResult);
            }else{
                throw new VacancyNotFoundException("Not found");
            }
        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching vacancies: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching vacancies", e);
        }
    }

    @Override
    public VacancyDto updateVacancy(Long id , VacancyCreationDto vacancyCreationDto) {
        try{
            Optional<Vacancy> vacancy = vacancyRepo.findById(id);
            if(vacancy.isPresent()){
                Vacancy vacancyResult = vacancy.get();
                logger.info("vacancy of {} has been fetched Successfully", id);
                vacancyResult.setJobTitle(vacancyCreationDto.getJobTitle());
                vacancyResult.setEmploymentType(vacancyCreationDto.getEmploymentType());
                vacancyResult.setRequirements(vacancyCreationDto.getRequirements());
                vacancyResult.setResponsibilities(vacancyCreationDto.getResponsibilities());
                vacancyResult.setContactEmail(vacancyCreationDto.getContactEmail());
                vacancyResult.setJobDescription(vacancyCreationDto.getJobDescription());
                vacancyResult.setApplicationDeadline(vacancyCreationDto.getApplicationDeadline());
                Vacancy result = vacancyRepo.save(vacancyResult);
                logger.info("vacancy of {} has been Updated Successfully", id);
                return vacancyMapper.toVacancyDto(result);
            }else{
                logger.error("Not found vacancy {}",id);
                throw new VacancyNotFoundException("Not found");
            }

        } catch (Exception e) {
            logger.error("An unexpected error occurred while Updating vacancies: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while Updating vacancies", e);
        }
    }

    @Override
    public String deleteVacancy(Long id) {
        try{
            //Fetching All Vacancies
            Optional<Vacancy> vacancy = vacancyRepo.findById(id);
            if(vacancy.isPresent()){
                vacancyRepo.deleteById(id);
                logger.info("vacancy of {} has been deleted Successfully", id);
               return "Deleted Successfully";
            }else{
                throw new VacancyNotFoundException("Not found");
            }
        } catch (Exception e) {
            logger.error("An unexpected error occurred while deleting vacancies: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while deleting vacancies", e);
        }
    }

    @Override
    public long getVacancyCount() {
        try {
            // Fetching count of all vacancies
            long count = vacancyRepo.count();
            logger.info("Total vacancies available: {}", count);
            return count;
        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching vacancy count: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching vacancy count", e);
        }
    }
}
