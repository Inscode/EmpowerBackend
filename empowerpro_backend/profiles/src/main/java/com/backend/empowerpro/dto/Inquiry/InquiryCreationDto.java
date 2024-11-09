package com.backend.empowerpro.dto.Inquiry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InquiryCreationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String description;
}
