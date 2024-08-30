package com.example.officemanagementsystemapp.controller;

import com.example.officemanagementsystemapp.model.Transaction;
import com.example.officemanagementsystemapp.model.TransactionDTO;
import com.example.officemanagementsystemapp.service.AccountService;
import com.example.officemanagementsystemapp.service.TransactionService;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/transactions")
    public String viewTransactionPage(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.addAttribute("listTransactions", transactions);
        model.addAttribute("listAccounts", accountService.getAllAccounts());

        // DateTimeFormatter ile tarih formatlama
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<TransactionDTO> transactionDTOs = transactions.stream()
                .map(transaction -> {
                    String accountName = "Unknown"; //
                    if (transaction.getAccount() != null) {
                        accountName = transaction.getAccount().getAccountName();
                    }
                    return new TransactionDTO(
                            transaction.getId(),
                            transaction.getDescription(),
                            transaction.getAmount(),
                            transaction.getTransactionDate().format(formatter),
                            transaction.getType(),
                            accountName
                    );
                })
                .toList();
        model.addAttribute("listTransactionsDTO", transactionDTOs);

        return "transactions";
    }



    @GetMapping("/showNewTransactionForm")
    public String showNewTransactionForm(Model model) {
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        model.addAttribute("listAccounts", accountService.getAllAccounts());
        return "new_transaction";
    }

    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute("transaction") Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions";
    }

    @GetMapping("/showFormForUpdateTransaction/{id}")
    public String showFormForUpdateTransaction(@PathVariable(value = "id") long id, Model model) {
        Transaction transaction = transactionService.getTransactionById(id);
        model.addAttribute("transaction", transaction);
        model.addAttribute("listAccounts", accountService.getAllAccounts());
        return "update_transaction";
    }

    @GetMapping("/deleteTransaction/{id}")
    public String deleteTransaction(@PathVariable(value = "id") long id) {
        transactionService.deleteTransactionById(id);
        return "redirect:/transactions";
    }
}