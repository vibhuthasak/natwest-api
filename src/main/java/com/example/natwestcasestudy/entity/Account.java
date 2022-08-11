package com.example.natwestcasestudy.entity;

import com.example.natwestcasestudy.service.utility.SequenceGenerator;

public class Account {
    private int accountId;
    private double balance;
    private int ownerId;
    
    public Account(int ownerId, double initialBalance) {
        this.accountId = SequenceGenerator.getNextAccount();
        this.balance = initialBalance;
        this.ownerId = ownerId;
    }
    
    public int getAccountId() {
        return accountId;
    }
    
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public int getOwnerId() {
        return ownerId;
    }
    
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
