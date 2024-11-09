package com.backend.empowerpro.service.impl;

import com.backend.empowerpro.dto.complaint.ComplaintCreationDto;
import com.backend.empowerpro.dto.complaint.ComplaintDto;
import com.backend.empowerpro.entity.Complaint;
import com.backend.empowerpro.exception.ComplaintNotFoundException;
import com.backend.empowerpro.repository.ComplaintRepo;
import com.backend.empowerpro.service.ComplaintService;
import com.backend.empowerpro.service.FileService;
import com.backend.empowerpro.utils.ComplaintMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ComplaintServiceImp implements ComplaintService {
    private static final Logger logger = LoggerFactory.getLogger(Complaint.class);
    private final ComplaintRepo complaintRepo;
    private final ComplaintMapper complaintMapper;

    private final FileService fileService;

    @Value("${project.complaints}")
    private String fileUploadDir;

    @Override
    public List<ComplaintDto> getAllComplaints() {
        try{
            List<Complaint> allComplaints = complaintRepo.findAll();
            logger.info("All Complaints has been Fetched Successfully");
            return allComplaints.stream()
                    .map(complaintMapper::toComplaintDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching complaints: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching complaints", e);
        }
    }

    @Override
    public List<ComplaintDto> getComplaintsToMe() {
        return List.of();
    }

    @Override
    public List<ComplaintDto> getComplaintsFromMyself() {
        return List.of();
    }

    @Override
    public String createComplaint(ComplaintCreationDto complaintCreationDto) {
        try {
            // Convert DTO to Complaint entity
            Complaint complaint = complaintMapper.toComplaint(complaintCreationDto);

            // Save the complaint to the database
            Complaint savedComplaint = complaintRepo.save(complaint);

            logger.info("Complaint has been created successfully: {}", complaint);
            return "Complaint created successfully with ID: " + complaint.getId();

        }catch (Exception e) {
            logger.error("An unexpected error occurred while creating complaint: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while creating complaint", e);
        }
    }



    @Override
    public ComplaintDto getOneComplaint(Long id) {
        try{
            //Fetching All Vacancies
            Optional<Complaint> complaint = complaintRepo.findById(id);
            if(complaint.isPresent()){
                Complaint complaintResult = complaint.get();
                logger.info("complaint of {} has been fetched Successfully", id);
                return complaintMapper.toComplaintDto(complaintResult);
            }else{
                throw new ComplaintNotFoundException("Not found");
            }
        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching complaints: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching complaints", e);
        }
    }

//    @Override
//    public ComplaintDto updateComplaint(Long id, ComplaintCreationDto complaintCreationDto) {
//        try{
//            Optional<Complaint> complaint = complaintRepo.findById(id);
//            if(complaint.isPresent()){
//                Complaint complaintResult = complaint.get();
//                logger.info("Complaint of {} has been fetched Successfully", id);
//                complaintResult.setStatus(complaintCreationDto.getStatus());
//                complaintResult.setDate(new Date());
//                complaintResult.setAbout(complaintCreationDto.getAbout());
//                complaintResult.setSender(complaintCreationDto.getSender());
//                complaintResult.setAssignedTo(complaintCreationDto.getAssignedTo());
//                complaintResult.setDescription(complaintCreationDto.getDescription());
//                complaintResult.setReply(complaintCreationDto.getReply());
//                complaintResult.setFilesToUpload(complaintCreationDto.getFilesToUpload());
//                Complaint result = complaintRepo.save(complaintResult);
//                logger.info("Complaint of {} has been Updated Successfully", id);
//                return complaintMapper.toComplaintDto(result);
//            }else{
//                logger.error("Not found Complaint {}",id);
//                throw new ComplaintNotFoundException("Not found");
//            }
//
//        } catch (Exception e) {
//            logger.error("An unexpected error occurred while Updating complaints: {}", e.getMessage(), e);
//            throw new RuntimeException("An unexpected error occurred while Updating complaints", e);
//        }
//    }

    @Override
    public String deleteComplaint(Long id) {
        try{
            //Fetching All Vacancies
            Optional<Complaint> complaint = complaintRepo.findById(id);
            if(complaint.isPresent()){
                complaintRepo.deleteById(id);
                logger.info("complaint of {} has been deleted Successfully", id);
                return "Deleted Successfully";
            }else{
                throw new ComplaintNotFoundException("Not found");
            }
        } catch (Exception e) {
            logger.error("An unexpected error occurred while deleting complaints: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while deleting complaints", e);
        }
    }


    @Override
    public List<ComplaintDto> getComplaintsAssignedToHR() {
        try{
            List<Complaint> complaints = complaintRepo.findByAssignedTo("HR");
            logger.info("All Complaints has been Fetched Successfully");
            return complaints.stream()
                    .map(complaintMapper::toComplaintDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching complaints: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching complaints", e);
        }
    }
}
