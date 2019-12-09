package com.cashu.budgetapp.controller;

import com.cashu.budgetapp.model.AccountCreationForm;
import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Resource(name = "userService")
    UserService userService;

    @GetMapping("/register")
    public String showAccountCreationForm(HttpServletRequest request, Model model) {
        model.addAttribute("accountSubmitForm", new AccountCreationForm());

        return "register";
    }

    @PostMapping("/register")
    public String createAccount(HttpServletRequest request, Model model, @ModelAttribute("accountSubmitForm") AccountCreationForm form) {
        User user = userService.createUserFromCreationForm(form);

        if(user == null) {
            model.addAttribute("accountCreated", false);

            return "register";
        }

        //set security context to user and show who's logged in


        return "budget";
    }

    @RequestMapping(value = "/verify-email", params = "email", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> verifyEmail(HttpServletRequest request, Model model, @RequestParam("email") String email){
        Map<String, Object> response = new HashMap<>();

        response.put("emailAlreadyTaken", userService.getUserByEmail(email) != null);

        return response;
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request, Model model){
        return "hello";
    }

    @GetMapping("/testHomePage")
    public String testHomePage(HttpServletRequest request, Model model){
        return "testhome";
    }

}
