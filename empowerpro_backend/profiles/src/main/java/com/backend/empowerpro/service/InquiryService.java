package com.backend.empowerpro.service;

import com.backend.empowerpro.dto.Inquiry.InquiryCreationDto;
import com.backend.empowerpro.dto.Inquiry.InquiryDto;
import com.backend.empowerpro.dto.suppliers.SuppliersCreationDto;
import com.backend.empowerpro.dto.suppliers.SuppliersDto;

import java.util.List;

public interface InquiryService {
    public List<InquiryDto> getAllInquiries();
    public String createInquiry(InquiryCreationDto inquiryCreationDto);
    public InquiryDto getOneInquiry(Long id);
    public InquiryDto updateInquiry(Long id,InquiryCreationDto inquiryCreationDto);
    public String deleteInquiry(Long id);
}
