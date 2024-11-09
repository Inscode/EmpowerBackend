package com.backend.empowerpro.utils;

import com.backend.empowerpro.dto.complaint.ComplaintCreationDto;
import com.backend.empowerpro.dto.complaint.ComplaintDto;
import com.backend.empowerpro.entity.Complaint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComplaintMapper {
    ComplaintDto toComplaintDto(Complaint complaint);
    Complaint toComplaint(ComplaintCreationDto complaintCreationDto);
}
