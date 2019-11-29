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

    public Long getUserCategoryBudgetId() {
        return userCategoryBudgetId;
    }

    public User getUser() {
        return user;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public int getBudgetPercentage() {
        return budgetPercentage;
    }

    public void setUserCategoryBudgetId(Long userCategoryBudgetId) {
        this.userCategoryBudgetId = userCategoryBudgetId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public void setBudgetPercentage(int budgetPercentage) {
        this.budgetPercentage = budgetPercentage;
    }
}