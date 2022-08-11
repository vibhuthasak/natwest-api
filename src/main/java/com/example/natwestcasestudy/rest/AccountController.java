package com.example.natwestcasestudy.rest;

import com.example.natwestcasestudy.entity.Account;
import com.example.natwestcasestudy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    
    @Autowired
    AccountService accountService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
