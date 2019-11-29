package com.cashu.budgetapp.controller;

import com.cashu.budgetapp.dao.UserDao;
import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.service.UserServiceImpl;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

/**
 * This is a controller firmly for testing purposes
 */
@Controller
public class TestController {

    @PersistenceContext
    EntityManager em;

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "userService")
    private UserServiceImpl userServiceImpl;

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

        User user = userServiceImpl.getUserByEmail("sunny");

        if (user != null) {
            int failedCount = user.getNumberOfFailedLogins() + 1;
            user.setNumberOfFailedLogins(failedCount);

            if (failedCount > 5) {
                user.setLocked(true);
            }

            userServiceImpl.saveUser(user);
        }

        return "hello";
    }

    @GetMapping("/")
    public String test2(HttpServletRequest request, Model model){

        /* //Get user by ID
        Long id = new Long(0);
        UserEvent user = em.find(UserEvent.class, id);
        System.out.println(user.getEventName());
         */

        return "home";
    }
}
