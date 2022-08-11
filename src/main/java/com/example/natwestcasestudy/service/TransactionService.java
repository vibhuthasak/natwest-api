package com.example.natwestcasestudy.service;

import com.example.natwestcasestudy.data.DataSource;
import com.example.natwestcasestudy.entity.Transaction;
import com.example.natwestcasestudy.service.utility.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    
    @Autowired
    Validator validator;
    
    public List<Transaction> getAllTransactions() {
        return DataSource.transactionsList;
    }
    
    public int makeTransaction(Transaction transaction) {
        // Adding transaction to the database as a pending transaction
        DataSource.transactionsList.add(transaction);
        
        // Needs to validate accountId is exists on the database
        if (validator.validateAccounts(transaction)) {
            // Check the amount is available on the source account
            if (validator.validateAmount(transaction)) {
                // Do the transaction
                return 0;
            } else {
                // Source account balance is insufficient
                return 2;
            }
        } else {
            // Account id is not available
            return 1;
        }
    }
}
