package com.rgada28.expensetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Size(min = 3,message = "Category name should have min 3 characters")
    private String categoryName;

    private Double amount;

    private Boolean isExpense;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private final List<Category> subCategories = new ArrayList<>();


    @ManyToOne()
    @NotNull(message = "User cannot be null")
    @JoinColumn(name = "user_id")
    private AppUser user;


}
