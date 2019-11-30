package com.cashu.budgetapp.service;

import com.cashu.budgetapp.dao.UserCategoryBudgetDao;
import com.cashu.budgetapp.model.ExpenseCategory;
import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.model.UserCategoryBudget;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userCategoryBudgetService")
public class UserCategoryBudgetService {
    @Resource(name = "userCategoryBudgetDao")
    UserCategoryBudgetDao userCategoryBudgetDao;

    public UserCategoryBudget getUserCategoryBudgetByUserAndCategory(User user, ExpenseCategory category) {
        return userCategoryBudgetDao.getUserCategoryBudgetByUserAndCategory(user, category);
    }
}
