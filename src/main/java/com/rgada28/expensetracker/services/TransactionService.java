package com.rgada28.expensetracker.services;

import com.rgada28.expensetracker.model.Transaction;
import com.rgada28.expensetracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction getById(Integer transactionId) throws Exception {
        //TODO Throw more Specific Exception
     return   transactionRepository.findById(transactionId).orElseThrow(() -> new Exception("Transaction record not found for following id: - " + transactionId));
    }
    public Transaction createTransaction(Transaction transaction){
        //TODO add validaions
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactionsByAccount(Integer accountId){
        //TODO Check whether the account exists
        return transactionRepository.findAllByAccountAccountId(accountId);
    }

    public void deleteTransaction(Integer transactionId){
        //TODO check whether the transaction exists
        transactionRepository.deleteById(transactionId);
    }

    public void createOrUpdateTransaction(Transaction transaction){
        //TODO check whether the transaction exists
        transactionRepository.saveAndFlush(transaction);
    }
}
