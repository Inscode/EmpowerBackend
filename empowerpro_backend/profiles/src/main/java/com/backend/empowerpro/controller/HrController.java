package com.backend.empowerpro.controller;


import com.backend.empowerpro.dto.complaint.ComplaintCreationDto;
import com.backend.empowerpro.dto.complaint.ComplaintDto;
import com.backend.empowerpro.dto.leave.LeaveCreationDto;
import com.backend.empowerpro.dto.leave.LeaveDto;
import com.backend.empowerpro.dto.vacancy.VacancyCreationDto;
import com.backend.empowerpro.dto.vacancy.VacancyDto;
import com.backend.empowerpro.entity.Complaint;
import com.backend.empowerpro.entity.Leave;
import com.backend.empowerpro.repository.ComplaintRepo;
import com.backend.empowerpro.service.ComplaintService;
import com.backend.empowerpro.service.LeaveService;
import com.backend.empowerpro.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hr")
@RequiredArgsConstructor
@CrossOrigin("*")
public class HrController {
//    public final ComplaintService complaintService;
    private final VacancyService vacancyService;
    private final LeaveService leaveService;
    private final ComplaintService complaintService;
    private final String UPLOAD_DIR = "C:\\Users\\Insaf\\Desktop\\LatestEmpowerpro\\empowerpro_backend\\uploads\\complaints\\";
    private final ComplaintRepo complaintRepo;
//    @PreAuthorize("hasAuthority('HR')")
    @PostMapping("/vacancy-creation")
    public ResponseEntity<String> creation(@RequestBody VacancyCreationDto vacancyCreationDto) {
        return ResponseEntity.ok(vacancyService.createVacancy(vacancyCreationDto));
    }
//    @PreAuthorize("hasAuthority('HR')")
    @GetMapping("/vacancy-get-all")
    public ResponseEntity<List<VacancyDto>> getAllVacancies() {
        return ResponseEntity.ok(vacancyService.getAllVacancies());
    }

    @GetMapping("/vacancy-get-count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(vacancyService.getVacancyCount());
    }
//    @PreAuthorize("hasAuthority('HR')")
    @GetMapping("/vacancy-get-one/{id}")
    public ResponseEntity<VacancyDto> getOneVacancy(@PathVariable Long id) {
        return ResponseEntity.ok(vacancyService.getOneVacancy(id));
    }
//    @PreAuthorize("hasAuthority('HR')")
    @PutMapping("/vacancy-update/{id}")
    public ResponseEntity<VacancyDto> updateVacancy(@PathVariable Long id, @RequestBody VacancyCreationDto vacancyCreationDto) {
        return ResponseEntity.ok(vacancyService.updateVacancy(id,vacancyCreationDto ));
    }
//    @PreAuthorize("hasAuthority('HR')")
    @DeleteMapping ("/vacancy-delete/{id}")
    public ResponseEntity<String> deleteVacancy(@PathVariable Long id) {
        return ResponseEntity.ok(vacancyService.deleteVacancy(id));
    }

    @PostMapping("/leave-creation")
    public ResponseEntity<String> creation(@RequestBody LeaveCreationDto leaveCreationDto) {
        return ResponseEntity.ok(leaveService.createLeave(leaveCreationDto));
    }
    //    @PreAuthorize("hasAuthority('HR')")
    @GetMapping("/leave-get-all")
    public ResponseEntity<List<LeaveDto>> getAllLeaves() {
        return ResponseEntity.ok(leaveService.getAllLeaves());
    }
    //    @PreAuthorize("hasAuthority('HR')")
    @GetMapping("/leave-get-one/{id}")
    public ResponseEntity<LeaveDto> getOneLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.getOneLeave(id));
    }
    //    @PreAuthorize("hasAuthority('HR')")
    @PutMapping("/leave-update/{id}")
    public ResponseEntity<LeaveDto> updateVacancy(@PathVariable Long id, @RequestBody LeaveCreationDto leaveCreationDto) {
        return ResponseEntity.ok(leaveService.updateLeave(id,leaveCreationDto ));
    }
    //    @PreAuthorize("hasAuthority('HR')")
    @DeleteMapping ("/leave-delete/{id}")
    public ResponseEntity<String> deleteLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.deleteLeave(id));
    }

    @GetMapping("/leave-get-filtered")
    public ResponseEntity<List<LeaveDto>> getAllLeaves(
            @RequestParam(required = false) String timePeriod,
            @RequestParam(required = false) String status) {
            List<LeaveDto> leaves = leaveService.getLeavesByFilter(timePeriod, status);
            return ResponseEntity.ok(leaves);
    }

    @PostMapping("/complaint-creation")
    public ResponseEntity<String> createComplaint(
//            @RequestParam String status,
            @RequestParam String about,
//            @RequestParam String sender,
            @RequestParam String assignedTo,
            @RequestParam String description,
            @RequestParam(required = false) MultipartFile file) throws IOException {

        ComplaintCreationDto complaintCreationDto = ComplaintCreationDto.builder()
                .status("pending")
                .about(about)
//                .sender(sender)
                .assignedTo(assignedTo)
                .description(description)
                .date(new Date())
                .build();

        // Handle file upload if provided
        if (file != null && !file.isEmpty()) {
            String filePath = UPLOAD_DIR + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            complaintCreationDto.setFilesToUpload(filePath);
        }

        String savedComplaint = complaintService.createComplaint(complaintCreationDto);
        return new ResponseEntity<>(savedComplaint, HttpStatus.CREATED);
    }
    //    @PreAuthorize("hasAuthority('HR')")
    @GetMapping("/complaint-get-all")
    public ResponseEntity<List<ComplaintDto>> getAllComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }
    //    @PreAuthorize("hasAuthority('HR')")
        @GetMapping("/complaint-get-one/{id}")
    public ResponseEntity<ComplaintDto> getOneComplaint(@PathVariable Long id) {
        return ResponseEntity.ok(complaintService.getOneComplaint(id));
    }

    @DeleteMapping ("/complaint-delete/{id}")
    public ResponseEntity<String> deleteComplaint(@PathVariable Long id) {
        return ResponseEntity.ok(complaintService.deleteComplaint(id));
    }

    @GetMapping("/assigned-to-hr")
    public ResponseEntity<List<ComplaintDto>> getComplaintsAssignedToUser() {
        List<ComplaintDto> complaints = complaintService.getComplaintsAssignedToHR();
        return ResponseEntity.ok(complaints);
    }


}
