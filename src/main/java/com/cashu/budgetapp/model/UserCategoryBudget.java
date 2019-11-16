package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_category_budget")
public class UserCategoryBudget implements Serializable {

    @EmbeddedId
    private UserCategoryBudgetId userCategoryBudgetId;

    @Column(name = "budget_percentage")
    private int budgetPercentage;
}