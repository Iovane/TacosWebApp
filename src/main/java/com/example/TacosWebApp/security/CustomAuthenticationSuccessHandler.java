package com.example.TacosWebApp.security;

import com.example.TacosWebApp.entities.User;
import com.example.TacosWebApp.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final UserServiceImpl userServiceImpl;

    public CustomAuthenticationSuccessHandler(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        String username = authentication.getName();

        User theUser = userServiceImpl.findByUsername(username);

        HttpSession session = request.getSession();
        session.setAttribute("user", theUser);
        response.sendRedirect("/");
    }
}
