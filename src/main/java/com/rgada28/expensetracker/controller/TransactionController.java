package com.rgada28.expensetracker.controller;


import com.rgada28.expensetracker.model.Transaction;
import com.rgada28.expensetracker.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transact){
        return new ResponseEntity<Transaction>( service.createTransaction(transact), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Transaction> updateTransaction(@Valid @RequestBody Transaction transaction,Integer transactionId) throws Exception {
        return new ResponseEntity<Transaction>( service.updateTransaction(transaction,transactionId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Integer transactionId){
        return new ResponseEntity<String>("Transaction Delete successfully",HttpStatus.OK);
    }

}
