package com.cashu.budgetapp.security;

import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private UserService userServiceImpl;

    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Transactional
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        UserDetails loginUser = (UserDetails) authentication.getPrincipal();

        User user = userServiceImpl.getUserByEmail(loginUser.getUsername());
        user.setNumberOfFailedLogins(0);
        userServiceImpl.saveUser(user);

        logger.info("User \"" + loginUser.getUsername() + "\" successfully logged in.");
        response.sendRedirect("/");
    }
}
