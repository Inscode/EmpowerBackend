package com.backend.empowerpro.controller;

import com.backend.empowerpro.auth.entity.Employee;
import com.backend.empowerpro.auth.entity.RefreshToken;
import com.backend.empowerpro.auth.service.AuthService;
import com.backend.empowerpro.auth.service.JwtService;
import com.backend.empowerpro.auth.service.RefreshTokenService;
import com.backend.empowerpro.auth.utils.AuthResponse;
import com.backend.empowerpro.auth.utils.LoginRequest;
import com.backend.empowerpro.auth.utils.RefreshTokenRequest;
import com.backend.empowerpro.auth.utils.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
//    @PreAuthorize("hasAuthority('Admin')")


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> register(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@RequestBody RefreshTokenRequest request){
        RefreshToken refreshToken = refreshTokenService.verifyRefreshToken(request.getRefreshToken() );
        Employee user = refreshToken.getEmployee();

        String accessToken = jwtService.generateToken(user);
        return ResponseEntity.ok(AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .build());
    }
}