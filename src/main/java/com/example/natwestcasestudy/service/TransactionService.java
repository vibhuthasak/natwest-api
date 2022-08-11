package com.example.natwestcasestudy.service;

import com.example.natwestcasestudy.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>();
    }
    
}
