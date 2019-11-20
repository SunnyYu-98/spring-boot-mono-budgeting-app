package com.cashu.budgetapp.controller;

import com.cashu.budgetapp.model.UserEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/hello")
    public String test(HttpServletRequest request, Model model){
        return "hello";
    }

    @GetMapping("/")
    public String test2(HttpServletRequest request, Model model){

        Long id = new Long(0);
        UserEvent user = em.find(UserEvent.class, id);
        System.out.println(user.getEventName());

        return "home";
    }

}
