package com.example.officemanagementsystemapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private double amount;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @Column(name = "type") // e.g., "income" or "expense"
    private String type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
