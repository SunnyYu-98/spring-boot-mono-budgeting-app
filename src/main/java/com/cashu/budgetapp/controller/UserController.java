package com.cashu.budgetapp.controller;

import com.cashu.budgetapp.model.AccountCreationForm;
import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.service.EmailService;
import com.cashu.budgetapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Resource(name = "userService")
    UserService userService;

    @Resource(name = "emailService")
    EmailService emailService;

    @GetMapping("/register")
    public String showAccountCreationForm(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //user is already logged in
        User loggedInUser = userService.getCurrentLoggedInUser();
        if(loggedInUser != null) {
            model.addAttribute("user", loggedInUser);
            response.sendRedirect("/budget");
        }

        model.addAttribute("accountSubmitForm", new AccountCreationForm());

        return "register";
    }

    @PostMapping("/register")
    public String createAccount(HttpServletRequest request, Model model, @ModelAttribute("accountSubmitForm") AccountCreationForm form) {
        User user = userService.createUserFromCreationForm(form);
        if(user == null) {
            model.addAttribute("creationError", true);

            return "register";
        } else {
            model.addAttribute("accountCreated", true);

            return "login";
        }
    }

    @RequestMapping(value = "/verify-email", params = "email", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> verifyEmail(HttpServletRequest request, Model model, @RequestParam("email") String email){
        Map<String, Object> response = new HashMap<>();

        response.put("emailAlreadyTaken", userService.getUserByEmail(email) != null);

        return response;
    }

    @GetMapping("/password-reset-email")
    public String getPasswordReset(HttpServletRequest request, Model model) {
        return "passwordResetEmail";
    }

    @PostMapping("/password-reset-email")
    public String sendPasswordResetEmail(HttpServletRequest request, Model model) {

        String recipient = request.getParameter("email");
        String emailSubject = "Reset your password at Cash-U";
        String emailBody = "Hello, <br><br>Please click on the following link to reset your password: <br><br><a href=\"http://localhost:8080/reset-password?email=" + recipient + "&token=37b7c1eb-2625-4180-9091-a8d354ec679f\">Reset Password</a>";
        emailService.sendEmail(recipient, emailSubject, emailBody);

        model.addAttribute("emailSent", true);

        return "passwordResetEmail";
    }

    @GetMapping("/reset-password")
    public String getPasswordResetPage(HttpServletRequest request, Model model,
                                       @RequestParam(value = "email") String email,
                                       @RequestParam(value = "token", required = false) String token) {
        String correctToken = "37b7c1eb-2625-4180-9091-a8d354ec679f";
        if(token == null || token.isEmpty() || !token.equals(correctToken)){
            return "accessDenied";
        } else {
            model.addAttribute("email", email);
            //have a reset-password-land and redirect to this, so that the email and token wouldn't be in the URL
            return "resetPassword";
        }
    }

    @PostMapping("/reset-password")
    public String resetPassword(HttpServletRequest request, Model model){
        userService.resetUserPassword(request.getParameter("email"), request.getParameter("password"));

        model.addAttribute("passwordResetSuccess",true);
        return "login";
    }
}
