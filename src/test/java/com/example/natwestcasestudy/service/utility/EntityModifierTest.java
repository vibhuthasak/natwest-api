package com.example.natwestcasestudy.service.utility;

import com.example.natwestcasestudy.data.DataSource;
import com.example.natwestcasestudy.entity.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EntityModifierTest {
    @Test
    public void AccountTransactionTest() {
        Transaction transaction1 = new Transaction(10, 1, 2);
        
        EntityModifier entityModifier = new EntityModifier();
        
        int srcAccountId = transaction1.getSourceAccountId();
        int destAccountId = transaction1.getDestinationAccountId();
    
        double srcAccountAmountPrev = getAccountBalance(srcAccountId);
        double destAccountAmountPrev = getAccountBalance(destAccountId);
        
        // Do the transfer
        entityModifier.transferTransaction(transaction1);
    
        Double srcAccountAmountAfter = getAccountBalance(srcAccountId);
        Double destAccountAmountAfter = getAccountBalance(destAccountId);
    
        assertEquals(srcAccountAmountAfter, srcAccountAmountPrev - transaction1.getAmount());
        assertEquals(destAccountAmountAfter, destAccountAmountPrev + transaction1.getAmount());
    }
    
    public double getAccountBalance(int accountId) {
        return DataSource.accountsList.stream().filter(account -> account.getAccountId() == accountId).map(account -> account.getBalance()).findFirst().get();
    }
    
}