package com.cashu.budgetapp.service;

import com.cashu.budgetapp.dao.ExpenseDaoImpl;
import com.cashu.budgetapp.model.Expenses;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("expenseService")
public class ExpenseService {
    @Resource(name = "expensesDao")
    ExpenseDaoImpl expenseDao;

    @Transactional
    public void saveExpense(Expenses expense){
        expenseDao.saveExpense(expense);
    }
}
