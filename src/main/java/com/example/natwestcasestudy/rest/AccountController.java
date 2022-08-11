package com.example.natwestcasestudy.rest;

import com.example.natwestcasestudy.entity.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {
    
    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    public List<Account> getAllAccounts() {
        return new ArrayList<>();
    }
}
