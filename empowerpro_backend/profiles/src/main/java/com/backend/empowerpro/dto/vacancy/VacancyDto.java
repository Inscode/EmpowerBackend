package com.backend.empowerpro.dto.vacancy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VacancyDto {
    private Long id;
    private String jobTitle;
    private String employmentType;
    private String jobDescription;
    private String requirements;
    private String responsibilities;
    private Integer minSalary;
    private Integer maxSalary;
    private Date applicationDeadline;
    private String contactEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
