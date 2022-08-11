package com.example.natwestcasestudy.service;

import com.example.natwestcasestudy.data.DataSource;
import com.example.natwestcasestudy.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    
    @Autowired
    DataSource dataSource;
    
    public List<Account> getAllAccounts() {
        return dataSource.accountsList;
    }
}
