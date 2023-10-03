package com.rgada28.expensetracker.controller;


import com.rgada28.expensetracker.model.Transaction;
import com.rgada28.expensetracker.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/transactions")
public class TransactionController {


    final private TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> getAllTransactionsByAccountId(@PathVariable Integer accountId){
        return service.getAllTransactionsByAccount(accountId);
    }

    @GetMapping("/{transactionId}")
    public Transaction getTransactionById(@PathVariable Integer transactionId) throws Exception {
        return service.getById(transactionId);
    }
}
