package com.example.officemanagementsystemapp.repository;

import com.example.officemanagementsystemapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}