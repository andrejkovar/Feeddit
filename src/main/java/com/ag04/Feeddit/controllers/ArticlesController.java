package com.ag04.Feeddit.controllers;

import com.ag04.Feeddit.entities.Article;
import com.ag04.Feeddit.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticlesController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getArticles(HttpServletRequest request){

        List<Article> articles = articleService.getAllArticles();

        ModelAndView model = new ModelAndView("articles");
        model.addObject("articles", articles);
        model.addObject("message", "Hy :D");
        model.setStatus(HttpStatus.OK);

        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getAddNewArticleForm(HttpServletRequest request){

        ModelAndView model = new ModelAndView("new-article");
        model.setStatus(HttpStatus.OK);

        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView addNewArticleForm(HttpServletRequest request){

        ModelAndView model = new ModelAndView();

        String headline = request.getParameter("headline");
        String link = request.getParameter("link");
        String author = request.getParameter("author");

        if (headline == null || headline.isEmpty() || link == null || link.isEmpty() || author == null || author.isEmpty()){

            model.addObject("message", "All fields are required!");
            model.setViewName("new-article");

            return model;
        }

        model.setViewName("redirect:/articles");
        model.setStatus(HttpStatus.CREATED);

        return model;
    }
}
