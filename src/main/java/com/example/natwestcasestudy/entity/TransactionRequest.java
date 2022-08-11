package com.example.natwestcasestudy.entity;

import javax.validation.constraints.NotNull;

public class TransactionRequest {
    @NotNull(message = "Amount cannot be null")
    private Double amount;
    @NotNull(message = "SourceAccountId cannot be null")
    private Integer sourceAccountId;
    @NotNull(message = "DestinationAccountId cannot be null")
    private Integer destinationAccountId;
    
    public TransactionRequest(Double amount, Integer sourceAccountId, Integer destinationAccountId) {
        super();
        this.amount = amount;
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
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
