package com.example.natwestcasestudy.entity;

import com.example.natwestcasestudy.service.utility.SequenceGenerator;

public class Transaction {
    private int transactionId;
    private double amount;
    private int sourceAccountId;
    private int destinationAccountId;
    
    private TransactionStatus transactionStatus;
    
    public Transaction(double amount, int sourceAccountId, int destinationAccountId) {
        this.transactionId = SequenceGenerator.getNextTransaction();
        this.amount = amount;
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.transactionStatus = TransactionStatus.PENDING;
    }
    
    public int getTransactionId() {
        return transactionId;
    }
    
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }
    
    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public int getSourceAccountId() {
        return sourceAccountId;
    }
    
    public void setSourceAccountId(int sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }
    
    public int getDestinationAccountId() {
        return destinationAccountId;
    }
    
    public void setDestinationAccountId(int destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }
}
