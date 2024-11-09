package com.backend.empowerpro.service.impl;

import com.backend.empowerpro.dto.Inquiry.InquiryCreationDto;
import com.backend.empowerpro.dto.Inquiry.InquiryDto;
import com.backend.empowerpro.entity.Inquiry;
import com.backend.empowerpro.exception.VacancyNotFoundException;
import com.backend.empowerpro.repository.InquiryRepo;
import com.backend.empowerpro.service.InquiryService;
import com.backend.empowerpro.utils.InquiryMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InquiryServiceImp implements InquiryService {
    private static final Logger logger = LoggerFactory.getLogger(InquiryService.class);
    private final InquiryRepo inquiryRepo;
    private final InquiryMapper inquiryMapper;
    @Override
    public List<InquiryDto> getAllInquiries() {
        try{
            //Fetching All Vacancies
            List<Inquiry> allInquires = inquiryRepo.findAll();
            logger.info("All inquires has been Fetched Successfully");
            //Mapping All Vacancies to result List
            return allInquires.stream()
                    .map(inquiryMapper::toInquiryDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching Inquiries: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching Inquiries", e);
        }
    }

    @Override
    public String createInquiry(InquiryCreationDto inquiryCreationDto) {
        try{
            Inquiry inquiry = inquiryMapper.toInquiry(inquiryCreationDto);
           inquiryRepo.save(inquiry);
            logger.info("Inquiry has been created Successfully {}",inquiry);
            return "Successfully Created";
        }catch (Exception e){
            logger.error("An unexpected error occurred while creating Inquiry: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while creating Inquiry", e);
        }
    }

    @Override
    public InquiryDto getOneInquiry(Long id) {
        try{
            //Fetching All Vacancies
            Optional<Inquiry> inquiry = inquiryRepo.findById(id);
            if(inquiry.isPresent()){
                Inquiry inquiryResult = inquiry.get();
                logger.info("Inquiry of {} has been fetched Successfully", id);
                return inquiryMapper.toInquiryDto(inquiryResult);
            }else{
                throw new VacancyNotFoundException("Not found");
            }
        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching inquiry: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching inquiry", e);
        }
    }

    @Override
    public InquiryDto updateInquiry(Long id, InquiryCreationDto inquiryCreationDto) {
        try{
            Optional<Inquiry> inquiry = inquiryRepo.findById(id);
            if(inquiry.isPresent()){
                Inquiry inquiryResult = inquiry.get();
                logger.info("Inquiry of {} has been fetched Successfully", id);
                inquiryResult.setFirstName(inquiryCreationDto.getFirstName());
                inquiryResult.setLastName(inquiryCreationDto.getLastName());
                inquiryResult.setEmail(inquiryCreationDto.getEmail());
                inquiryResult.setContactNumber(inquiryCreationDto.getContactNumber());
                inquiryResult.setDescription(inquiryCreationDto.getDescription());
                Inquiry result = inquiryRepo.save(inquiryResult);
                logger.info("Inquiry of {} has been Updated Successfully", id);
                return inquiryMapper.toInquiryDto(result);
            }else{
                logger.error("Not found Inquiry {}",id);
                throw new VacancyNotFoundException("Not found");
            }

        } catch (Exception e) {
            logger.error("An unexpected error occurred while Updating Inquiry: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while Updating Inquiry", e);
        }
    }

    @Override
    public String deleteInquiry(Long id) {
        try{
            //Fetching All Vacancies
            Optional<Inquiry> inquiry = inquiryRepo.findById(id);
            if(inquiry.isPresent()){
                inquiryRepo.deleteById(id);
                logger.info("inquiry of {} has been deleted Successfully", id);
                return "Deleted Successfully";
            }else{
                throw new VacancyNotFoundException("Not found");
            }
        } catch (Exception e) {
            logger.error("An unexpected error occurred while deleting inquiry: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while deleting Inquiry", e);
        }
    }
}
