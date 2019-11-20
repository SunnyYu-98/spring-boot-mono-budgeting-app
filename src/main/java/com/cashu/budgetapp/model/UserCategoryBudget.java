package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_category_budget")
public class UserCategoryBudget implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_cat_bud_id")
    private Long userCategoryBudgetId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = ExpenseCategory.class)
    @JoinColumn(name = "expense_cat_id")
    private ExpenseCategory category;

    @Column(name = "budget_percentage")
    private int budgetPercentage;
}