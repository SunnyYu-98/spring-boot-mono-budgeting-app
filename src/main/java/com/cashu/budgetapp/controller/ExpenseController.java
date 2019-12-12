package com.cashu.budgetapp.controller;

import com.cashu.budgetapp.model.Expenses;
import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.service.ExpenseCategoryService;
import com.cashu.budgetapp.service.ExpenseService;
import com.cashu.budgetapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@Controller
public class ExpenseController {

    @PersistenceContext
    EntityManager em;

    @Resource(name = "userService")
    UserService userService;

    @Resource(name = "expenseService")
    ExpenseService expenseService;

    @Resource(name = "expenseCategoryService")
    ExpenseCategoryService expenseCategoryService;

    @RequestMapping(value = "/add-expense", method = RequestMethod.POST)
    public void saveExpense(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String expenseSign = request.getParameter("expenseSign");
        String expenseName = request.getParameter("expenseName");
        double expenseAmount = Double.parseDouble(request.getParameter("expenseAmount"));

        if(expenseSign.equals("-"))
            expenseAmount *= -1;

        User currentUser = userService.getCurrentLoggedInUser();

        Expenses expense = new Expenses();
        expense.setAmount(expenseAmount);
        expense.setExpenseName(expenseName);
        expense.setCategory(expenseCategoryService.getCategoryById(3)); //Food for now
        expense.setUser(currentUser);
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        expense.setExpDate(sqlDate);

        expenseService.saveExpense(expense);

        //this can totally be replaced by ajax, but got no time!
        response.sendRedirect("/budget");
    }


}
