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

    @NotNull(message = "Account name cannot be null")
    protected String accountName;

    @NotNull(message = "Account number cannot be null")
    private String accountNumber;

    @PositiveOrZero(message = "Account Balance cannot be negative")
    private Double balance;

    @NotNull(message = "Account either has to be lending or savings product")
    private boolean isLending;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name="user_id")
    private AppUser appUser;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}

