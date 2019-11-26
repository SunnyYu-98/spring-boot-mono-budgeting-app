package com.cashu.budgetapp.security;

import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.service.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Resource(name = "userService")
    private UserServiceImpl userServiceImpl;

    @Transactional
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        UserDetails loginUser = (UserDetails) authentication.getPrincipal();

        User user = userServiceImpl.getUserByEmail(loginUser.getUsername());
        user.setNumberOfFailedLogins(0);
        //user.setLastLoginDate(new Date());
        userServiceImpl.saveUser(user);

        System.out.println("in custom authentication success handler");
        response.sendRedirect("/");
    }
}
