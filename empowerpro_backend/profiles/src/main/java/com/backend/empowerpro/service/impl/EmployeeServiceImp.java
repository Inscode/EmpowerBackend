package com.backend.empowerpro.service.impl;


import com.backend.empowerpro.auth.entity.Employee;
import com.backend.empowerpro.auth.repository.EmployeeRepository;
import com.backend.empowerpro.auth.utils.EmployeeResponse;
import com.backend.empowerpro.auth.utils.EmployeeUpdateRequest;
import com.backend.empowerpro.exception.EmployeeNotFoundException;
import com.backend.empowerpro.service.EmployeeService;
import com.backend.empowerpro.service.FileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final FileService fileService;
    @Value("${project.employeeProfile}")
    private String path;
    @Value("${base.url}")
    private String baseUrl;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return List.of();
    }

    @Override
    public EmployeeResponse getOneEmployee(Long id) {
        try{
            Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
            logger.info("Employee has been Fetched Successfully");
            //Generate PosterUrl
            String posterUrl = baseUrl + "/file/profile/" + employee.getProfile();
            logger.info("posterurl Created Successfully");
            //Map to MovieDtoObject
            EmployeeResponse response = new EmployeeResponse(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getAddress(),
                    employee.getEmail(),
                    employee.getUsername(),
                    employee.getWorkTitle(),
                    employee.getRole(),
                    employee.getSummary(),
                    employee.getSkills(),
                    employee.getExperiences(),
                    employee.getProfile(),
                    posterUrl
            );
            logger.info("Response has been Created Successfully");
            return response;
        }catch (Exception e) {
            logger.error("An unexpected error occurred while fetching Employee: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching vacancies", e);
        }

    }

//    @Override
//    public EmployeeResponse updateEmployee(Long id, EmployeeUpdateRequest employeeUpdateRequest, MultipartFile file) throws IOException {
//        Employee found_employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not found"));
//        String fileName = found_employee.getProfile();
//        if(file != null){
//            Files.deleteIfExists(Paths.get(path + File.separator + fileName));
//            fileName =fileService.uploadFile(path,file);
//        }
//        employeeUpdateRequest.setProfile(fileName);
//        String profileUrl = baseUrl + "/file/" + found_employee.getProfile();
//        Employee updatedEmployee = new Employee(
//                found_employee.getId(),
//                employeeUpdateRequest.getFirstName(),
//                employeeUpdateRequest.getLastName(),
//                employeeUpdateRequest.getAddress(),
//                employeeUpdateRequest.getEmail(),
//                employeeUpdateRequest.getPhoneNumber(),
//                employeeUpdateRequest.getWorkTitle(),
//                employeeUpdateRequest.getRole(),
//                employeeUpdateRequest.getUserName(),
//                employeeUpdateRequest.getExperiences(),
//                employeeUpdateRequest.getSummary(),
//                employeeUpdateRequest.getProfile()
//        )
//    }

    @Override
    public EmployeeResponse deleteEmployee(Long id) {
        return null;
    }

    @Override
    public Long getEmployeeCount() {
        try {
            // Fetching count of all vacancies
            long count = employeeRepository.count();
            logger.info("Total Employees available: {}", count);
            return count;
        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching employee count: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching employee count", e);
        }
    }
}
