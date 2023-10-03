package com.rgada28.expensetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;

    private String merchant;

    @NotNull(message = "debit/credit cannot be null")
    private Boolean debit;

    @Positive(message = "Amount cannot be negative")
    @NotNull(message = "Amount cannot be null")
    private Double amount;

//    @Positive(message = "Cashback cannot be negative")
//    private double cashback;

    @DateTimeFormat
    @NotNull(message = "Date cannot be null")
    private LocalDate transactionDate;

//    @Positive(message = "Own Share cannot be negative")
//    private double ownShare;

//    private String description;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    @NotNull(message = "Account cannot be null")
    private Account account;

    @NotNull(message = "Mode of payment cannot be null")
    private String modeOfPayment;

}

