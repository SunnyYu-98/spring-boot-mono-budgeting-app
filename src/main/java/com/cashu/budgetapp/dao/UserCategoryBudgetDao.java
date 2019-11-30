package com.cashu.budgetapp.dao;

import com.cashu.budgetapp.model.ExpenseCategory;
import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.model.UserCategoryBudget;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("userCategoryBudgetDao")
public class UserCategoryBudgetDao {

    public UserCategoryBudget getUserCategoryBudgetByUserAndCategory(User user, ExpenseCategory category) {
        List<UserCategoryBudget> allUserBudgets = user.getAllUserBudgets();

        return allUserBudgets.stream()
                .filter(budget ->
                        budget.getCategory().getExpCatId() == (category.getExpCatId()))
                .collect(Collectors.toList()).get(0);
    }
}
