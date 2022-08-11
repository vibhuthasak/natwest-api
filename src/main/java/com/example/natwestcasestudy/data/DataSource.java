package com.example.natwestcasestudy.data;

import com.example.natwestcasestudy.entity.Account;
import com.example.natwestcasestudy.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataSource {
    public List<Account> accountsList = new ArrayList<>();
    public List<Transaction> transactionsList = new ArrayList<>();
    
    public DataSource() {
        accountsList.add(new Account(1, 1, 100));
        accountsList.add(new Account(2, 3, 42));
        accountsList.add(new Account(3, 1, 139));
        accountsList.add(new Account(4, 4, 532));
        accountsList.add(new Account(5, 8, 132));
        accountsList.add(new Account(6, 3, 10));
        accountsList.add(new Account(7, 2, 111));
    }
}
