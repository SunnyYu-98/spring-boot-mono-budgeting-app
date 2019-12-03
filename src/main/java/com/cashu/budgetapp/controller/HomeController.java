package com.cashu.budgetapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String showHomepage(HttpServletRequest request, HttpServletResponse response, Model model){

        return "home";
    }

    @RequestMapping(value = "/budget", method = RequestMethod.GET)
    public String showBudgetPage(HttpServletRequest request, HttpServletResponse response, Model model){
        return "budget";
    }

    @RequestMapping(value = "/privacy", method = RequestMethod.GET)
    public String showPrivacyPage(HttpServletRequest request, HttpServletResponse response, Model model){
        return "privacy";
    }

    @RequestMapping(value = "/terms", method = RequestMethod.GET)
    public String showTermsPage(HttpServletRequest request, HttpServletResponse response, Model model){
        return "terms";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String showContactPage(HttpServletRequest request, HttpServletResponse response, Model model){
        return "contact";
    }


}
