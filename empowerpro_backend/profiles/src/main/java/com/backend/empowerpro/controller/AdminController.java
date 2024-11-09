package com.backend.empowerpro.controller;

import com.backend.empowerpro.auth.service.AuthService;
import com.backend.empowerpro.auth.utils.AuthResponse;
import com.backend.empowerpro.auth.utils.EmployeeResponse;
import com.backend.empowerpro.auth.utils.RegisterRequest;
import com.backend.empowerpro.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AuthService authService;
    private final EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping("/register")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authService.register(registerRequest));
    }

    private RegisterRequest convertToRegisterRequest(String registerRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(registerRequest, RegisterRequest.class);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<EmployeeResponse> getOneEmployeeHandler(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getOneEmployee(id), HttpStatus.FOUND);
    }

    @GetMapping("/open")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hello");
    }
}
