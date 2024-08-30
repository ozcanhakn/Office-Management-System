package com.example.officemanagementsystemapp.repository;

import com.example.officemanagementsystemapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}