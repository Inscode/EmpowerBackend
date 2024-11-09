package com.backend.empowerpro.dto.Inquiry;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InquiryDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String description;
    private LocalDateTime submittedAt;
}
