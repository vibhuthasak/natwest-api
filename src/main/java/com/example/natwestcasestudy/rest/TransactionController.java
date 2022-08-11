package com.example.natwestcasestudy.rest;

import com.example.natwestcasestudy.entity.Transaction;
import com.example.natwestcasestudy.entity.TransactionRequest;
import com.example.natwestcasestudy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/transaction")
    public String postTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction(transactionRequest.getAmount(), transactionRequest.getSourceAccountId(), transactionRequest.getDestinationAccountId());
        int response = transactionService.makeTransaction(transaction);
        if (response == 1) {
            // Account not found
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account Not Found");
        } else if (response == 2) {
            // Account balance is not sufficient
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient Account Balance");
        } else {
            return "OK";
        }
    }
}
