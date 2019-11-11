package com.cashu.budgetapp.model;

import javax.persistence.*;

@Entity
@Table(name = "user_category_budget")

public class UserCategoryBudget {

    // Budget Percentage
    @Column(name = "budget_percentage")
    private int budgetPercentage;

    // FK  expense cat ID and userid.



}
