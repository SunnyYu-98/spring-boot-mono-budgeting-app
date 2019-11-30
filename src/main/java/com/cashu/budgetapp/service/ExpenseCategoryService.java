package com.cashu.budgetapp.service;

import com.cashu.budgetapp.dao.ExpenseCategoryDao;
import com.cashu.budgetapp.model.ExpenseCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("expenseCategoryService")
public class ExpenseCategoryService {

    @Resource(name = "expenseCategoryDao")
    ExpenseCategoryDao expenseCategoryDao;

    public ExpenseCategory getCategoryById(int id){
        return expenseCategoryDao.getCategoryById(id);
    }
}
