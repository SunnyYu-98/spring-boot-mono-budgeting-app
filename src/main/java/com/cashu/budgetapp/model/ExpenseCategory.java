package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "expense_category")
public class ExpenseCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_cat_id")
    private Long expCatId;

    @Column(name = "category_name")
    private String categoryName;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "userCategoryBudgetId", targetEntity = UserCategoryBudgetId.class)
    //private List<UserCategoryBudget> allUserBudgets = new ArrayList<>();
}