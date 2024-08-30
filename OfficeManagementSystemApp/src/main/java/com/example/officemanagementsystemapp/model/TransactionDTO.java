package com.example.officemanagementsystemapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long id;
    private String description;
    private double amount;
    private String formattedDate;
    private String type;
    private String accountName;
}
