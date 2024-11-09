package com.backend.empowerpro.service;

import com.backend.empowerpro.auth.entity.EmployeeRole;
import com.backend.empowerpro.auth.utils.EmployeeResponse;
import com.backend.empowerpro.auth.utils.EmployeeUpdateRequest;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    public List<EmployeeResponse> getAllEmployees();
    public EmployeeResponse getOneEmployee(Long id);
    public EmployeeResponse deleteEmployee(Long id);
    public Long getEmployeeCount();
}