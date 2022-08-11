package com.example.natwestcasestudy.service.utility;

/**
 * This class is created to generate Ids for Account and Transaction entities. This requirement came up because
 * we are using the on memory database.
 */
public class SequenceGenerator {
    private static int AccountId = 1;
    private static int transactionId = 1;
    
    public static synchronized int getNextAccount() {
        return AccountId++;
    }
    
    public static synchronized int getNextTransaction() {
        return transactionId++;
    }
}
