package com.ag04.Feeddit.controllers;

import com.ag04.Feeddit.entities.Article;
import com.ag04.Feeddit.entities.VotedArticle;
import com.ag04.Feeddit.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticlesController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getArticles(@RequestParam String username){

        List<VotedArticle> votedArticles = articleService.getAllVotedArticles(username);

        ModelAndView model = new ModelAndView("articles");
        model.addObject("votedArticles", votedArticles);

        if (votedArticles.isEmpty()) {
            model.addObject("message", "There are no articles to display");
        }

        model.setStatus(HttpStatus.OK);

        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getAddNewArticleForm(){

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

        articleService.addNewArticle(request.getParameter("username"), headline, author, link);

        model.setViewName("redirect:/articles");
        model.addObject("message", "New article '" + headline + "' is added");
        model.setStatus(HttpStatus.CREATED);

        return model;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ModelAndView getArticlesByUser(@PathVariable String username){

        List<Article> articles = articleService.getArticlesByUsername(username);

        ModelAndView model = new ModelAndView("user-articles");
        model.addObject("articles", articles);

        if (articles.isEmpty()) {
            model.addObject("message", "You didn't add any article yet");
        }

        model.setStatus(HttpStatus.OK);

        return model;
    }

    @RequestMapping(value = "/{username}/{id}", method = RequestMethod.POST)
    public ModelAndView deleteArticlesByUser(@PathVariable String username, @PathVariable String id, @RequestParam String method){

        ModelAndView model = new ModelAndView();

        if (!method.equals("DELETE")){
            model.addObject("message", "Invalid request method");
            model.setStatus(HttpStatus.METHOD_NOT_ALLOWED);

            return model;
        }

        int articleId = Integer.parseInt(id);
        if (!articleService.isArticleExists(articleId)) {

            model.addObject("message", "Article does not exist!");
            model.setStatus(HttpStatus.NOT_FOUND);
            model.setViewName("redirect:/articles/" + username);

            return model;
        }

        String headline = articleService.getArticleById(articleId).getHeadline();

        articleService.deleteArticleById(articleId);

        model.addObject("message", "Article '" + headline +"' is deleted");
        model.setStatus(HttpStatus.OK);
        model.setViewName("redirect:/articles/" + username);

        return model;
    }
}
