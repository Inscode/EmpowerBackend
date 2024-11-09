package com.backend.empowerpro.controller;

import com.backend.empowerpro.auth.utils.EmployeeUpdateRequest;
import com.backend.empowerpro.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private EmployeeUpdateRequest convertToEmployeeUpdateRequest(String employeeUpdateReq) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(employeeUpdateReq, EmployeeUpdateRequest.class);
    }

    @GetMapping("/employee-get-count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(employeeService.getEmployeeCount());
    }


}
