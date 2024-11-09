package com.backend.empowerpro.auth.utils;

import com.backend.empowerpro.auth.entity.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateRequest{
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Long phoneNumber;
    private EmployeeRole role;
    private String workTitle;
    private String userName;
    private String password;
    private String summary;
    private String skills;
    private String experiences;
    private String profile;
    private String profilePath;
}
