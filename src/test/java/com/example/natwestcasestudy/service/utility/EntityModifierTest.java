package com.example.natwestcasestudy.service.utility;

import com.example.natwestcasestudy.data.DataSource;
import com.example.natwestcasestudy.entity.Transaction;
import com.example.natwestcasestudy.entity.TransactionStatus;
import com.example.natwestcasestudy.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityModifierTest {
    
    @Autowired
    TransactionService transactionService;
    
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
    
    private double getAccountBalance(int accountId) {
        return DataSource.accountsList.stream().filter(account -> account.getAccountId() == accountId).map(account -> account.getBalance()).findFirst().get();
    }
    
    @Test
    public void initialTransactionStatusTest() {
        Transaction transaction1 = new Transaction(10, 1, 2);
        assertEquals(TransactionStatus.PENDING, transaction1.getTransactionStatus());
    }
    
    @Test
    public void modifyTransactionStatusTest() {
        Transaction transaction1 = new Transaction(10, 1, 2);
        // Adding the transaction to the DB temporary
        DataSource.transactionsList.add(transaction1);
        
        EntityModifier entityModifier = new EntityModifier();
    
        entityModifier.modifyTransaction(transaction1, TransactionStatus.FAILED);
        
        assertEquals(TransactionStatus.FAILED, getTxStatus(transaction1.getTransactionId()));
    
        entityModifier.modifyTransaction(transaction1, TransactionStatus.SUCCESS);
    
        assertEquals(TransactionStatus.SUCCESS, getTxStatus(transaction1.getTransactionId()));
    }
    
    private TransactionStatus getTxStatus(int transactionId) {
        return DataSource.transactionsList.stream().filter(transaction -> transaction.getTransactionId() == transactionId).map(transaction -> transaction.getTransactionStatus()).findFirst().get();
    }
    
}