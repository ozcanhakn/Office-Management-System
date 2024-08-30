package com.example.officemanagementsystemapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "balance")
    private double balance;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}
