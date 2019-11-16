package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UserCategoryBudgetId implements Serializable {
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = ExpenseCategory.class)
    @JoinColumn(name = "expense_cat_id")
    private ExpenseCategory category;
}
