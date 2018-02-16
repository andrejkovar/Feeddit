package com.ag04.Feeddit.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Value("${spring.application.name}")
    String appName;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getLoginPage(){

        ModelAndView model = new ModelAndView("login");
        model.addObject("appname", appName);
        model.addObject("message", "Enter your username and password");

        return model;
    }
}
