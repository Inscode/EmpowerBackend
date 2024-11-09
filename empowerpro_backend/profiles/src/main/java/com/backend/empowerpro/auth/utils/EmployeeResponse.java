package com.backend.empowerpro.auth.utils;


import com.backend.empowerpro.auth.entity.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class EmployeeResponse {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String username;
    private String WorkTitle;
    private EmployeeRole role;
    private String summary;
    private String skills;
    private String experiences;
    private String profile;
    private String profilePath;
}

