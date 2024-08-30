package com.example.officemanagementsystemapp.service;

import com.example.officemanagementsystemapp.model.Account;
import com.example.officemanagementsystemapp.model.Transaction;
import com.example.officemanagementsystemapp.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        Account account = transaction.getAccount();
        double amount = transaction.getAmount();
        if ("income".equals(transaction.getType())) {
            accountService.updateAccountBalance(account.getId(), amount);
        } else if ("expense".equals(transaction.getType())) {
            accountService.updateAccountBalance(account.getId(), -amount);
        }
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(long id) {
        Optional<Transaction> optional = transactionRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Transaction not found for id :: " + id);
        }
    }

    @Override
    public void deleteTransactionById(long id) {
        transactionRepository.deleteById(id);
    }
}