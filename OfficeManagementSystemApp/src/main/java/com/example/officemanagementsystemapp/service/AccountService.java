package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Account;

import java.util.List;


public interface AccountService {
    List<Account> getAllAccounts();
    void saveAccount(Account account);
    Account getAccountById(long id);
    void deleteAccountById(long id);
    void updateAccountBalance(long id, double amount);
}
