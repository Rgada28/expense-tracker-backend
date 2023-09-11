package com.rgada28.expensetracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double amount;

    private Boolean isExpense;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

}
