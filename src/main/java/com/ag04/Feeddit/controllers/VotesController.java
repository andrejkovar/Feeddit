package com.ag04.Feeddit.controllers;

import com.ag04.Feeddit.entities.Article;
import com.ag04.Feeddit.entities.Vote;
import com.ag04.Feeddit.services.ArticleService;
import com.ag04.Feeddit.services.UserService;
import com.ag04.Feeddit.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/votes")
public class VotesController {

    @Autowired
    VoteService voteService;

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView vote(String username, int articleId, boolean vote){

        ModelAndView model = new ModelAndView("redirect:/articles");

        if (articleService.isArticleExists(articleId)){

            Article article = articleService.getArticleById(articleId);
            Vote tempVote = voteService.getVoteByUsernameAndArticleId(username, articleId);

            // if user already voted for that article
            if (tempVote != null){

                // if user send different vote
                if(tempVote.getVote() != vote) {
                    article.setVotes(vote ? article.getVotes() + 2 : article.getVotes() - 2);

                    tempVote.setVote(vote);
                    articleService.save(article);
                }

            } else {
                article.setVotes(vote ? article.getVotes() + 1 : article.getVotes() - 1);
                tempVote = new Vote(userService.getUser(username), articleService.getArticleById(articleId), vote);

                voteService.save(tempVote);
                articleService.save(article);
            }

            model.addObject("message", vote ? "You voted up" : "You voted down");
        } else {
            //error
        }

        return model;
    }
}
