package com.ag04.Feeddit.controllers;

import com.ag04.Feeddit.services.LoggedUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/logout")
public class LogoutController {

    @Autowired
    private LoggedUsersService loggedUsersService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView logout(@RequestParam String username, @RequestParam String token){

        loggedUsersService.logoutUser(username, token);

        ModelAndView model = new ModelAndView("redirect:/login");
        model.addObject("message", "You have successfully logged out");
        return model;
    }
}
