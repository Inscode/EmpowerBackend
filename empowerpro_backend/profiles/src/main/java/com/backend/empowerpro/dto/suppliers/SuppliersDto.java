package com.backend.empowerpro.dto.suppliers;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter

@AllArgsConstructor


public class SuppliersDto{

    private Long id;
    private String supplierName;
    private String contactEmail;
    private String contactPhoneNo;
    private String supplierDescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
