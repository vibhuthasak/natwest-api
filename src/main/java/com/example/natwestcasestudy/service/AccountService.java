package com.example.natwestcasestudy.service;

import com.example.natwestcasestudy.entity.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    
    public List<Account> getAllAccounts() {
        return new ArrayList<>();
    }
}
