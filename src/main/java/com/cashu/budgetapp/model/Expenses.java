package com.cashu.budgetapp.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Long expenseId;

    @Column (name = "amount")
    private double amount;

    @Column (name = "name")
    private String expenseName;

    @Column(name = "expense_date")
    private Date expDate;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Long userId;

    @ManyToOne(targetEntity = ExpenseCategory.class)
    @JoinColumn(name = "expense_cat_id")
    private Long categoryId;

}
