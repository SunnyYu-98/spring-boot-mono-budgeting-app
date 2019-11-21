package com.cashu.budgetapp.security;

import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.service.UserService;
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

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        //setDefaultFailureUrl(DEFAULT_FAILURE_URL);
        super.onAuthenticationFailure(request, response, exception);

        //need to pass the email
        if (exception instanceof BadCredentialsException) {
            lockUser(request.getParameter("username"));
        }

    }

    private void lockUser(String username) {
        //username = email
        User user = userService.getUserByEmail(username);

        if (user != null) {
            int failedCount = user.getNumberOfFailedLogins() + 1;
            user.setNumberOfFailedLogins(failedCount);

            if (failedCount > 5) {
                user.setLocked(true);
            }

            userService.saveUser(user);
        }
    }}
