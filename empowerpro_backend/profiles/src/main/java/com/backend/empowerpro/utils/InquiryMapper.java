package com.backend.empowerpro.utils;


import com.backend.empowerpro.dto.Inquiry.InquiryCreationDto;
import com.backend.empowerpro.dto.Inquiry.InquiryDto;
import com.backend.empowerpro.dto.complaint.ComplaintDto;
import com.backend.empowerpro.entity.Complaint;
import com.backend.empowerpro.entity.Inquiry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InquiryMapper {
    InquiryDto toInquiryDto(Inquiry inquiry);
    Inquiry toInquiry(InquiryCreationDto inquiryCreationDto);
}
