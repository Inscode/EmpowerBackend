package com.backend.empowerpro.controller;


import com.backend.empowerpro.dto.Inquiry.InquiryCreationDto;
import com.backend.empowerpro.dto.Inquiry.InquiryDto;

import com.backend.empowerpro.service.EmployeeService;
import com.backend.empowerpro.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final InquiryService inquiryService;

    @PostMapping("/inquiry-create")
    public ResponseEntity<String> creation(@RequestBody InquiryCreationDto inquiryCreationDto){
        return ResponseEntity.ok(inquiryService.createInquiry(inquiryCreationDto));
    }
    @GetMapping("/inquiry-get-all")
    public ResponseEntity<List<InquiryDto>> getAllInquiries() {
        return ResponseEntity.ok(inquiryService.getAllInquiries());
    }

    @GetMapping("/inquiry-get-one/{id}")
    public ResponseEntity<InquiryDto> getOneVacancy(@PathVariable Long id) {
        return ResponseEntity.ok(inquiryService.getOneInquiry(id));
    }

    @PutMapping("/inquiry-update/{id}")
    public ResponseEntity<InquiryDto> updateInquiry(@PathVariable Long id, @RequestBody InquiryCreationDto inquiryCreationDto) {
        return ResponseEntity.ok(inquiryService.updateInquiry(id,inquiryCreationDto ));
    }

    @DeleteMapping ("/inquiry-delete/{id}")
    public ResponseEntity<String> deleteInquiry(@PathVariable Long id) {
        return ResponseEntity.ok(inquiryService.deleteInquiry(id));
    }



}
