package com.rgada28.expensetracker.services;

import com.rgada28.expensetracker.dto.AccountResponseDTO;
import com.rgada28.expensetracker.model.Account;
import com.rgada28.expensetracker.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    public AccountService(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    public AccountResponseDTO createAccount(Account account){
        //TODO ADD VALIDATIONS
       return AccountResponseDTOfromAccount(accountRepository.saveAndFlush(account));
    }

    public AccountResponseDTO getAccountById(Integer accountId) throws Exception {
        return AccountResponseDTOfromAccount(accountRepository.findById(accountId).orElseThrow(()-> new Exception("Account record not found for following id:-"+ accountId)));
    }

    //TODO ADD a method to return onl Active accounts

    public List<AccountResponseDTO> getAllAccountsByUserId(Integer userId){
        return  accountRepository.findAllByAppUserUserId(userId).stream().map(this::AccountResponseDTOfromAccount).toList();
    }

    public AccountResponseDTO updateAccount(Account account, Integer accountId) throws Exception {
        getAccountById(accountId);
        return AccountResponseDTOfromAccount(accountRepository.saveAndFlush(account));
    }

    public void deleteAccount(Integer accountId) throws Exception {
        getAccountById(accountId);
        accountRepository.deleteById(accountId);
    }

    public Account AccountResponseDtotoAccount(AccountResponseDTO accountResponseDTO){

        return this.modelMapper.map(accountResponseDTO,Account.class);
    }

    public AccountResponseDTO AccountResponseDTOfromAccount(Account account){
        return this.modelMapper.map(account,AccountResponseDTO.class);
    }
}
