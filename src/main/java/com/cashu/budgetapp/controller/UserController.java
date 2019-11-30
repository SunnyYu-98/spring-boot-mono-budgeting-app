package com.cashu.budgetapp.controller;

import com.cashu.budgetapp.model.AccountCreationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @GetMapping("/create-account")
    public String showAccountCreationForm(HttpServletRequest request, Model model) {
        model.addAttribute("accountSubmitForm", new AccountCreationForm());

        return "accountCreationForm";
    }

    @PostMapping("/create-account")
    public String createAccount(HttpServletRequest request, Model model, @ModelAttribute("accountSubmitForm") AccountCreationForm form) {
        System.out.println(form.getFirstName());

        return "home";
    }

    @GetMapping("/hello")
    public String test(HttpServletRequest request, Model model){
        return "hello";
    }

    @GetMapping("/testHomePage")
    public String test2(HttpServletRequest request, Model model){
        return "home";
    }

}
