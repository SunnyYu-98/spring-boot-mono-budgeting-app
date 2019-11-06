package com.cashu.budgetapp;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/hello")
    public String test(HttpServletRequest request, Model model){
        return "hello";
    }

    @GetMapping("/test")
    public String test2(HttpServletRequest request, Model model){
        return "test";
    }

}
