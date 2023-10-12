package com.rgada28.expensetracker.controller;


import com.rgada28.expensetracker.dto.AccountResponseDTO;
import com.rgada28.expensetracker.model.Account;
import com.rgada28.expensetracker.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}")
    public AccountResponseDTO getAccountById(@PathVariable Integer accountId) throws Exception {
        return accountService.getAccountById(accountId);

    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@Valid @RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountResponseDTO> updateTransaction(@Valid @RequestBody Account account, Integer accountId) throws Exception {
        return new ResponseEntity<>(accountService.updateAccount(account, accountId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Integer accountId) throws Exception {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>("Account Delete successfully", HttpStatus.OK);
    }
}
