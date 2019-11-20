package com.cashu.budgetapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @GetMapping("/hello")
    public String test(HttpServletRequest request, Model model){
        return "hello";
    }

    @GetMapping("/testHomePage")
    public String test2(HttpServletRequest request, Model model){
        return "home";
    }

}
