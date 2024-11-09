package com.backend.empowerpro.dto.applicants;

import com.backend.empowerpro.dto.vacancy.VacancyDto;
import com.backend.empowerpro.entity.Vacancy;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicantsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer nic;
    private String address;
    private String email;
    private int phoneNumber;
    private String university;
    private String experienceTitle;
    private String companyName;
    private Date workedFrom;
    private Date workedTo;
    private String resume;
    private String resumePath;
    private LocalDateTime submittedAt;
    private VacancyDto vacancy;

}
