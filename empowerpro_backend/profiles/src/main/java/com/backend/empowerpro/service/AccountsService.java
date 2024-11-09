package com.backend.empowerpro.service;

import com.backend.empowerpro.dto.accounts.AccountsCreationDto;
import com.backend.empowerpro.dto.accounts.AccountsDto;

import java.util.List;

public interface AccountsService {
    public List<AccountsDto> getAllAccounts();
    public String createAccounts(AccountsCreationDto accountsCreationDto);
    public AccountsDto getOneAccounts(Long id);
    public AccountsDto updateAccounts(Long id,AccountsCreationDto accountsCreationDto);
    public String deleteAccounts(Long id);
    public List<AccountsDto> getAllAccountsByIncome();
    public List<AccountsDto> getAllAccountsByExpense();

}
