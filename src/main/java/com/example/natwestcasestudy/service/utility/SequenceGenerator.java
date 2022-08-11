package com.example.natwestcasestudy.service.utility;

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
