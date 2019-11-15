package com.cashu.budgetapp.model;

import javax.persistence.*;

@Entity
@Table (name = "expense_category")
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_cat_id")
    private Long expCatId;

    @Column(name = "category_name")
    private String categoryName;
}