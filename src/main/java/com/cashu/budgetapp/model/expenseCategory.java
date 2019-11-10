package com.cashu.budgetapp.model;

import javax.persistence.*;

@Entity
@Table (name = "expense_category")
public class expenseCategory {

    // Expense Category ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_cat_id")
    private Long expCatId;

    // Category name
    @Column(name = "category_name")
    private String catName;

    /*
    Two forein keys from expenses and user_category_budget
     */



}
