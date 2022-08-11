package com.example.natwestcasestudy.service.utility;

import com.example.natwestcasestudy.entity.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    
    @Test
    void validateAccountsValidAccounts() {
        
        Validator validator = new Validator();
        
        // Available accounts on the datasource = 1 to 7
        Transaction transaction1 = new Transaction(1, 10, 1, 2);
        Transaction transaction2 = new Transaction(2, 10, 2, 2);
        
        assertTrue(validator.validateAccounts(transaction1)); // Valid account
        assertTrue(validator.validateAccounts(transaction2)); // Valid same account
    }
    
    @Test
    void validateAccountInvalidAccounts() {
        
        Validator validator = new Validator();
        
        Transaction transaction1 = new Transaction(1,10, 12, 2);
        Transaction transaction2 = new Transaction(2, 10, 6, 8);
        Transaction transaction3 = new Transaction(3,10, 18, 11);
        
        assertFalse(validator.validateAccounts(transaction1)); // Valid and Invalid account
        assertFalse(validator.validateAccounts(transaction2)); // Invalid and Valid account
        assertFalse(validator.validateAccounts(transaction3)); // Both Invalid accounts
    }
    
    @Test
    void validateAmountAvailableBalance() {
        
        Validator validator = new Validator();
        
        Transaction transaction1 = new Transaction(1,15, 1, 2);
        assertTrue(validator.validateAmount(transaction1));
    }
    
    @Test
    void validateAmountNotAvailableBalance() {
        
        Validator validator = new Validator();
        
        Transaction transaction1 = new Transaction(2,150, 1, 2);
        assertFalse(validator.validateAmount(transaction1));
    }
}