package com.example.natwestcasestudy.service.utility;

import com.example.natwestcasestudy.data.DataSource;
import com.example.natwestcasestudy.entity.Account;
import com.example.natwestcasestudy.entity.Transaction;
import org.springframework.stereotype.Service;

@Service
public class EntityModifier {
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
}
