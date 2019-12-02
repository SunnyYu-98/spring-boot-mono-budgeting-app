package com.cashu.budgetapp.dao;

import com.cashu.budgetapp.model.Expenses;
import com.cashu.budgetapp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.util.List;
import java.util.function.Consumer;

@Repository("ExpensesDao")
public class ExpenseDaoImpl implements ExpensesDao {

    @PersistenceContext
    EntityManager entityManager;



    @Override
    public Expenses getExpenseById(int Id) {


        return entityManager.find(Expenses.class,Id);
    }



    public void deleteExpense(int ExpensesId) {

      Query query = entityManager.createNativeQuery(" delete from expenses where expense_id = ?1", Expenses.class);
      query.setParameter(1, ExpensesId);


    }


    @Override
    @Transactional
    public void saveExpense(Expenses expenses)
    {
        entityManager.persist(expenses);
    }




}

