package com.example.natwestcasestudy.rest;

import com.example.natwestcasestudy.entity.Transaction;
import com.example.natwestcasestudy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    
    @Autowired
    TransactionService transactionService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    
}
