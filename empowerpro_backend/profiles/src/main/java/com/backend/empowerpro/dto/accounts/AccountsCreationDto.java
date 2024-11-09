package com.backend.empowerpro.dto.accounts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountsCreationDto {
    private Long id;
    private String subject;
    private Float amount;
    private Date dateOfTransaction;
    private String category;
}
