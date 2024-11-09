package com.backend.empowerpro.auth.utils;

import com.backend.empowerpro.auth.entity.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    private String username;
    private String WorkTitle;
    private String firstName;
    private String lastName;
    private Long userId;
    private EmployeeRole role;
    private String profileUrl;

}

