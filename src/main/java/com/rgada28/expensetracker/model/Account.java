package com.rgada28.expensetracker.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer accountId;

    @NotNull(message = "First name cannot be null")
    protected String firstname;

    @NotNull(message = "Last name cannot be null")
    protected String lastname;

    @NotNull(message = "Account number cannot be null")
    private String accountNumber;

    @PositiveOrZero(message = "Account Balance cannot be negative")
    private Double balance;

    private Double creditLimit;

    @ManyToOne
    @JoinColumn(name="user_id")
    private AppUser appUser;

    @OneToMany(mappedBy = "fromAccount")
    private List<Transaction> transactions;
}

