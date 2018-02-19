package com.ag04.Feeddit.interceptors;

import com.ag04.Feeddit.services.LoggedUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private LoggedUsersService loggedUsersService;

    @Value("${spring.application.name}")
    String appName;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String username = request.getParameter("username");
        String token = request.getParameter("token");

        if(request.getRequestURI().contains("/login")) return true;

        if (loggedUsersService.isLoggedIn(username, token)) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        modelAndView.addObject("appname", appName);

        if (!(request.getRequestURI().contains("/login") || request.getRequestURI().contains("/logout"))){
            modelAndView.addObject("username", request.getParameter("username"));
            modelAndView.addObject("token", request.getParameter("token"));
        }

        if (request.getParameter("message") != null) {
            modelAndView.addObject("message", request.getParameter("message"));
        }
    }
}
