package com.example.natwestcasestudy.service.utility;

import com.example.natwestcasestudy.data.DataSource;
import com.example.natwestcasestudy.entity.Account;
import com.example.natwestcasestudy.entity.Transaction;
import com.example.natwestcasestudy.entity.TransactionStatus;
import org.springframework.stereotype.Service;

/**
 * This class use to modify the entities
 */
@Service
public class EntityModifier {
    
    // Transfer amount from one account to another account.
    // Src/Dest accounts and amount is on the Transaction entity
    public void transferTransaction(Transaction transaction) {
        
        int srcAccount = transaction.getSourceAccountId();
        int destAccount = transaction.getDestinationAccountId();
        double amount = transaction.getAmount();
        
        for (int i = 0; i < DataSource.accountsList.size(); i++) {
            Account account = DataSource.accountsList.get(i);
            if (account.getAccountId() == srcAccount) {
                double currentBal = account.getBalance();
                account.setBalance(currentBal - amount);
            }
            if (account.getAccountId() == destAccount) {
                double currentBal = account.getBalance();
                account.setBalance(currentBal + amount);
            }
        }
    }
    
    // Modify the transaction status of a transaction.
    // Search the DB and modify the transaction.
    public void modifyTransaction(Transaction transaction, TransactionStatus status) {
        for (int i = 0; i < DataSource.transactionsList.size(); i++) {
            Transaction ithTransaction = DataSource.transactionsList.get(i);
            if (ithTransaction.getTransactionId() == transaction.getTransactionId()) {
                ithTransaction.setTransactionStatus(status);
            }
        }
    }
}
