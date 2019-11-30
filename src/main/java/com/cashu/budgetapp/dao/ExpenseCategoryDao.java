package com.cashu.budgetapp.dao;

import com.cashu.budgetapp.model.ExpenseCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("expenseCategoryDao")
public class ExpenseCategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public ExpenseCategory getCategoryById(int id){
        return entityManager.find(ExpenseCategory.class, id);
    }
}