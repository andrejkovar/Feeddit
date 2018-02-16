package com.ag04.Feeddit.controllers;

import com.ag04.Feeddit.entities.User;
import com.ag04.Feeddit.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getLoginPage(){

        ModelAndView model = new ModelAndView("login");
        model.addObject("message", "Enter your username and password");
        model.setStatus(HttpStatus.OK);

        return model;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String username, @RequestParam String password){

        ModelAndView model = new ModelAndView();

        if(username == null || username.isEmpty()){

            model.addObject("message", "Username field can not by empty!");
            model.setStatus(HttpStatus.UNAUTHORIZED);
            model.setViewName("login");
            return model;
        }

        if(password == null || password.isEmpty()){

            model.addObject("message", "Password field can not by empty!");
            model.setStatus(HttpStatus.UNAUTHORIZED);
            model.setViewName("login");
            return model;
        }

        if(!loginService.isUserPasswordCorrect(username, password)){

            model.addObject("message", "Username or password is incorrect!");
            model.setStatus(HttpStatus.UNAUTHORIZED);
            model.setViewName("login");
            return model;
        }

        model.setStatus(HttpStatus.ACCEPTED);
        //model.setViewName("redirect:../articles");
        model.addObject("message", "Success!");
        model.setViewName("login");

        return model;
    }
}
