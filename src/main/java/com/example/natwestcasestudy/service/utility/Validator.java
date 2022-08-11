package com.example.natwestcasestudy.service.utility;

import com.example.natwestcasestudy.data.DataSource;
import com.example.natwestcasestudy.entity.Account;
import com.example.natwestcasestudy.entity.Transaction;
import org.springframework.stereotype.Service;

/**
 * Validator of AccountIds and Transaction Amount available on the source account.
 */
@Service
public class Validator {
    public boolean validateAccounts(Transaction transaction) {
        
        int sourceAccount = transaction.getSourceAccountId();
        int destAccount = transaction.getDestinationAccountId();
        
        boolean sourceFound = false;
        boolean destFound = false;
        
        // Checking account numbers are valid
        for (int i = 0; i < DataSource.accountsList.size(); i++) {
            int accountNumber = DataSource.accountsList.get(i).getAccountId();
            if (accountNumber == sourceAccount) {
                sourceFound = true;
            }
            if (accountNumber == destAccount) {
                destFound = true;
            }
        }
        return sourceFound && destFound;
    }
    
    public boolean validateAmount(Transaction transaction) {
        int sourceAccount = transaction.getSourceAccountId();
        
        double availableBalance = DataSource.accountsList.stream().filter(account -> sourceAccount == account.getAccountId()).map(Account::getBalance).findFirst().orElse(0.0);
        return availableBalance >= transaction.getAmount();
    }
}
