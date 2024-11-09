package com.backend.empowerpro.auth.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;
    @Column(nullable = false, length = 500)
    @NotBlank(message = "Cannot be Empty (RefreshToken)")
    private String  refreshToken;
    @Column(nullable = false)
    private Instant expirationTime;
    @OneToOne
    private Employee employee;
}
