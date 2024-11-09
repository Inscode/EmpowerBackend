package com.backend.empowerpro.dto.suppliers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuppliersCreationDto {
    private Long id;
    private String supplierName;
    private String contactEmail;
    private String contactPhoneNo;
    private String supplierDescription;

}
