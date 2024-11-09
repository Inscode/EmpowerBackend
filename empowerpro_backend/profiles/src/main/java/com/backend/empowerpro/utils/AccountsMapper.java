package com.backend.empowerpro.utils;

import com.backend.empowerpro.dto.accounts.AccountsCreationDto;
import com.backend.empowerpro.dto.accounts.AccountsDto;
import com.backend.empowerpro.entity.Accounts;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountsMapper {
    AccountsDto toAccountsDto(Accounts accounts);
    Accounts toAccounts(AccountsCreationDto accountsCreationDto);
}
