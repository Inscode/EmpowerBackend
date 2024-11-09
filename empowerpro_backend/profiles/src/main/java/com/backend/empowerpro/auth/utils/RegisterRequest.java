package com.backend.empowerpro.auth.utils;

import com.backend.empowerpro.auth.entity.EmployeeRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Long phoneNumber;
    private String workTitle;
    private EmployeeRole role;
    private String username;
    private String password;
    private String profile;
    private String profilePath;





}
