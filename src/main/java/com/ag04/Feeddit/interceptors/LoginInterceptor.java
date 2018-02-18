package com.ag04.Feeddit.interceptors;

import com.ag04.Feeddit.repositories.LoggedUserRepository;
import com.ag04.Feeddit.services.LoggedUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private LoggedUsersService loggedUsersService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String username = request.getParameter("username");
        String token = request.getParameter("token");

        if(request.getRequestURI().endsWith("/login")) return true;

        if (loggedUsersService.isLoggedIn(username, token)) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
    }
}
