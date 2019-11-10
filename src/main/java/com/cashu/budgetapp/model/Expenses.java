package com.cashu.budgetapp.model;


import javax.persistence.*;

@Entity
@Table(name = "expenses")
public class Expenses {

    // Expenses ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Long expId;

    // Expense amount
    @Column (name = "amount")
    private double amount;

    // Expense name
    @Column (name = "name")
    private String expname;

    // Expense date
    @Column(name = "expense_date")
    private java.sql.Date expDate;

    // Foreign keys are Expense Category ID and user ID

    // Not sure what im doing




}
