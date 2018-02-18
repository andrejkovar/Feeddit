package com.ag04.Feeddit.controllers;

import com.ag04.Feeddit.entities.Article;
import com.ag04.Feeddit.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticlesController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getArticles(@RequestParam String username, @RequestParam String token){

        List<Article> articles = articleService.getAllArticles();

        ModelAndView model = new ModelAndView("articles");
        model.addObject("articles", articles);
        model.addObject("username", username);
        model.addObject("token", token);
        model.addObject("message", "Hy :D");
        model.setStatus(HttpStatus.OK);

        return model;
    }

}
