package com.cashu.budgetapp.controller;

import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.model.UserCategoryBudget;
import com.cashu.budgetapp.service.ExpenseCategoryService;
import com.cashu.budgetapp.service.UserCategoryBudgetService;
import com.cashu.budgetapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This is a controller firmly for testing purposes
 */
@Controller
public class TestController {

    @PersistenceContext
    EntityManager em;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "userCategoryBudgetService")
    private UserCategoryBudgetService userCategoryBudgetService;

    @Resource(name = "expenseCategoryService")
    private ExpenseCategoryService expenseCategoryService;

    @Transactional
    @GetMapping("/hello2")
    public String test(HttpServletRequest request, Model model){
        //******** NOTE: Any function that changes the database, have to have the @Transactional annotation *******
        /*
        User user = userDao.findUserByEmail("sunny");
        System.out.println("user phone num: " + user.getPhoneNumber());

        user.setPhoneNumber("1111111111");
        System.out.println("user phone num: " + user.getPhoneNumber());

        System.out.println("Persisting...");
        em.persist(user);
         */
        //User user = userDao.findUserByEmail("sunny");
        /*
        User user = userServiceImpl.getUserByEmail("sunny");
        System.out.println("user phone num: " + user.getPhoneNumber());

        //user.setPhoneNumber("1111111111");
        System.out.println("user phone num: " + user.getPhoneNumber());

        int failedCount = user.getNumberOfFailedLogins() + 1;
        user.setNumberOfFailedLogins(failedCount);


        System.out.println("Persisting...");
        em.persist(user);
        userDao.saveUser(user);

         */

        User user = userService.getUserByEmail("sunny");

        if (user != null) {
            int failedCount = user.getNumberOfFailedLogins() + 1;
            user.setNumberOfFailedLogins(failedCount);

            if (failedCount > 5) {
                user.setLocked(true);
            }

            userService.saveUser(user);
        }

        return "privacy";
    }

    @GetMapping("/")
    public String test2(HttpServletRequest request, Model model){

        /* //Get user by ID
        Long id = new Long(0);
        UserEvent user = em.find(UserEvent.class, id);
        System.out.println(user.getEventName());
         */

        User user = userService.getCurrentLoggedInUser();
        if(user != null) {
            System.out.println("Currently logged in user: " + user.getEmail() + " " + user.getPhoneNumber());

            System.out.println("Getting UserCategoryBudgets");
            List<UserCategoryBudget> userBudgets = user.getAllUserBudgets();
            System.out.println("UserBudget#1: " + userBudgets.get(0).getCategory().getCategoryName() + ", " + userBudgets.get(0).getBudgetPercentage() + "%");

            UserCategoryBudget budget = userCategoryBudgetService.getUserCategoryBudgetByUserAndCategory(user, expenseCategoryService.getCategoryById(1));
            System.out.println("UserBudget#2: " + budget.getCategory().getCategoryName() + ", " + budget.getBudgetPercentage() + "%");
        }

        return "home";
    }
}
