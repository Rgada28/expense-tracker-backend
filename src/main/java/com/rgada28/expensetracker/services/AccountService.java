package com.rgada28.expensetracker.services;

import com.rgada28.expensetracker.model.Account;
import com.rgada28.expensetracker.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void createAccount(Account account){
        accountRepository.save(account);
    }
}
