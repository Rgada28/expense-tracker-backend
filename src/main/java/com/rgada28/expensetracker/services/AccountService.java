package com.rgada28.expensetracker.services;

import com.rgada28.expensetracker.model.Account;
import com.rgada28.expensetracker.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
        //TODO ADD VALIDATIONS
       return accountRepository.saveAndFlush(account);
    }

    public Account getAccountById(Integer accountId) throws Exception {
        return accountRepository.findById(accountId).orElseThrow(()-> new Exception("Account record not found for following id:-"+ accountId));
    }

    //TODO ADD a method to return onl Active accounts

    public List<Account> getAllAccountsByUserId(Integer userId){
        return  accountRepository.findAllByAppUserUserId(userId);
    }

    public Account updateAccount(Account account,Integer accountId) throws Exception {
        getAccountById(accountId);
        return accountRepository.saveAndFlush(account);
    }

    public void deleteAccount(Integer accountId) throws Exception {
        getAccountById(accountId);
        accountRepository.deleteById(accountId);
    }
}
