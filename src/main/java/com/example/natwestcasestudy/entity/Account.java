package com.example.natwestcasestudy.entity;

public class Account {
    private int accountId;
    private double balance;
    private int ownerId;
    
    public Account(int accountId, int ownerId, double initialBalance) {
        this.accountId = accountId;
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
