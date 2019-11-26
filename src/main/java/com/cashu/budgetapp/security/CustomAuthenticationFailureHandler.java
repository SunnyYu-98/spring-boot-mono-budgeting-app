package com.cashu.budgetapp.security;

import com.cashu.budgetapp.service.UserServiceImpl;

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
    private UserServiceImpl userService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        //setDefaultFailureUrl(DEFAULT_FAILURE_URL);
        super.onAuthenticationFailure(request, response, exception);

        System.out.println("In customer failure handler");

        System.out.println("request.getParameter(\"username\") = " + request.getParameter("username"));
        //need to pass the email
        if (exception instanceof BadCredentialsException) {
            userService.lockUser(request.getParameter("username"));
        }

    }
}