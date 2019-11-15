package com.cashu.budgetapp.Service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

public class UserController {

    @GetMapping("/hello")
    public String test(HttpServletRequest request, Model model){
        return "hello";
    }

}
