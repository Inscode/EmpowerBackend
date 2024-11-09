package com.backend.empowerpro.service.impl;

import com.backend.empowerpro.dto.accounts.AccountsCreationDto;
import com.backend.empowerpro.dto.accounts.AccountsDto;
import com.backend.empowerpro.entity.Accounts;
import com.backend.empowerpro.exception.AccountsNotFoundException;
import com.backend.empowerpro.exception.VacancyNotFoundException;
import com.backend.empowerpro.repository.AccountsRepo;
import com.backend.empowerpro.service.AccountsService;
import com.backend.empowerpro.utils.AccountsMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsServiceImp implements AccountsService {
    //Initializing of AccountsRepository for DB functions
    private final AccountsRepo accountsRepo;
    //For Debugging Purpose
    private static final Logger logger = LoggerFactory.getLogger(Accounts.class);
    //Initializing of Accounts Mapper
    private final AccountsMapper accountsMapper;

    @Override
    public List<AccountsDto> getAllAccounts() {
        try{
            //Fetching All Accounts Details from DB
            List<Accounts> allAccounts = accountsRepo.findAll();
            logger.info("All Accounts fetched Successfully");
            return allAccounts.stream()
                    .map(accountsMapper::toAccountsDto)
                    .collect(Collectors.toList());

        }catch (Exception e){
            logger.error("Error Has been Occurred {}",e.getMessage());
            throw new RuntimeException("An unexpected error occurred while fetching Accounts", e);
        }
    }

    @Override
    public String createAccounts(AccountsCreationDto accountsCreationDto) {
        try{
            Accounts accounts = accountsMapper.toAccounts(accountsCreationDto);
            accountsRepo.save(accounts);
            logger.info("Accounts has been created Successfully {}",accounts);
            return "Successfully Created";
        }catch (Exception e){
            logger.error("An unexpected error occurred while creating accounts: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while creating accounts", e);
        }
    }

    @Override
    public AccountsDto getOneAccounts(Long id) {
        try{
            //Fetching Accounts by ID;
            Optional<Accounts> accounts = accountsRepo.findById(id);
            if(accounts.isPresent()){
                Accounts accountsResult = accounts.get();
                logger.info("Accounts of {} has been fetched Successfully", id);
                return accountsMapper.toAccountsDto(accountsResult);
            }else{
                throw new AccountsNotFoundException("Not found");
            }
        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching accounts: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching accounts", e);
        }
    }

    @Override
    public AccountsDto updateAccounts(Long id, AccountsCreationDto accountsCreationDto) {
        try{
            Optional<Accounts> accounts = accountsRepo.findById(id);
            if(accounts.isPresent()){
                Accounts accountsResult = accounts.get();
                logger.info("Accounts of {} has been fetched Successfully which to be update", id);
                accountsResult.setAmount(accountsCreationDto.getAmount());
                accountsResult.setSubject(accountsCreationDto.getSubject());
                accountsResult.setDateOfTransaction(accountsCreationDto.getDateOfTransaction());
                accountsResult.setCategory(accountsCreationDto.getCategory());

                //Saving the updated Accounts
                Accounts result = accountsRepo.save(accountsResult);
                logger.info("vacancy of {} has been Updated Successfully", id);
                return accountsMapper.toAccountsDto(result);
            }else{
                logger.error("Not found accounts {}",id);
                throw new VacancyNotFoundException("Not found");
            }

        } catch (Exception e) {
            logger.error("An unexpected error occurred while Updating accounts: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while Updating accounts", e);
        }
    }

    @Override
    public String deleteAccounts(Long id) {
        try{
            //Fetching All Vacancies
            Optional<Accounts> accounts = accountsRepo.findById(id);
            if(accounts.isPresent()){
                accountsRepo.deleteById(id);
                logger.info("accounts of {} has been deleted Successfully", id);
                return "Deleted Successfully";
            }else{
                throw new AccountsNotFoundException("Not found");
            }
        } catch (Exception e) {
            logger.error("An unexpected error occurred while deleting accounts: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while deleting accounts", e);
        }
    }

    @Override
    public List<AccountsDto> getAllAccountsByIncome() {
        try{
            List<Accounts> allIncome = accountsRepo.findByCategory("INCOME");
                return allIncome.stream()
                        .map(accountsMapper::toAccountsDto)
                        .collect(Collectors.toList());


        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching Income: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching Income", e);
        }
    }

    @Override
    public List<AccountsDto> getAllAccountsByExpense() {
        try{
            List<Accounts> allIncome = accountsRepo.findByCategory("EXPENSE");
            return allIncome.stream()
                    .map(accountsMapper::toAccountsDto)
                    .collect(Collectors.toList());


        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching Expenses: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while fetching Expenses", e);
        }
    }
}
