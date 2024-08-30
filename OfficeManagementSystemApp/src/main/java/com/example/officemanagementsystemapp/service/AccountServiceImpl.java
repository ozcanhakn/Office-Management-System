package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Account;
import com.example.officemanagementsystemapp.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account getAccountById(long id) {
        Optional<Account> optional = accountRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Account not found for id :: " + id);
        }
    }

    @Override
    public void deleteAccountById(long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void updateAccountBalance(long id, double amount) {
        Account account = getAccountById(id);
        account.setBalance(account.getBalance() + amount);
        saveAccount(account);
    }
}