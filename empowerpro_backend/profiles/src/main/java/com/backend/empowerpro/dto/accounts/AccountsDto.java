package com.backend.empowerpro.dto.accounts;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountsDto {
    private Long id;
    private String subject;
    private Float amount;
    private Date dateOfTransaction;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
