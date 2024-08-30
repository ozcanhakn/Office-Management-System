package com.example.officemanagementsystemapp.controller;

import com.example.officemanagementsystemapp.model.Account;
import com.example.officemanagementsystemapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/accounts")
    public String viewAccountPage(Model model) {
        model.addAttribute("listAccounts", accountService.getAllAccounts());
        return "accounts";
    }

    @GetMapping("/showNewAccountForm")
    public String showNewAccountForm(Model model) {
        model.addAttribute("account", new Account());
        return "new_account";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") Account account) {
        accountService.saveAccount(account);
        return "redirect:/accounts";
    }

    @GetMapping("/showFormForUpdateAccount/{id}")
    public String showFormForUpdateAccount(@PathVariable(value = "id") long id, Model model) {
        Account account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        return "update_account";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable(value = "id") long id) {
        accountService.deleteAccountById(id);
        return "redirect:/accounts";
    }
}
