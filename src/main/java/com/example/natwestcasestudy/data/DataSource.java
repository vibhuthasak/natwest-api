package com.example.natwestcasestudy.data;

import com.example.natwestcasestudy.entity.Account;
import com.example.natwestcasestudy.entity.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {
    public static List<Account> accountsList = new ArrayList<>(Arrays.asList(
            new Account(1, 1, 100),
            new Account(2, 3, 42),
            new Account(3, 1, 139),
            new Account(4,4, 532),
            new Account(5,8, 132),
            new Account(6,3, 10),
            new Account(7,2, 111)
    ));
    
    public static List<Transaction> transactionsList = new ArrayList<>();
}