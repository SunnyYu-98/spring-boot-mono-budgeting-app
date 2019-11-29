package com.cashu.budgetapp.security;

import com.cashu.budgetapp.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("customAuthenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Resource(name = "userService")
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        setDefaultFailureUrl("/login?error");

        //username = email
        if (exception instanceof BadCredentialsException) {
            userService.lockUser(request.getParameter("username"));
            logger.info("userService.lockUser ran for " + request.getParameter("username"));
        }

        logger.warn("Exception thrown in AuthenticationFailureHandler, error: \"" + exception.getLocalizedMessage() + "\"");
        super.onAuthenticationFailure(request, response, exception);
    }
}