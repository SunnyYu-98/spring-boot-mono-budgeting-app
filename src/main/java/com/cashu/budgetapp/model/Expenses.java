package com.cashu.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "expenses")
public class Expenses implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "expense_id")
    private int expenseId;

    @Column (name = "amount")
    private double amount;

    @Column (name = "name")
    private String expenseName;

    @Column(name = "expense_date")
    private Date expDate;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = ExpenseCategory.class)
    @JoinColumn(name = "expense_cat_id")
    private ExpenseCategory category;

    /* Removing this so that the ID will be automatically generated
    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public Date getExpDate() {
        return expDate;
    }

    public User getUser() {
        return user;
    }

    public ExpenseCategory getCategory() {
        return category;
    }
}
