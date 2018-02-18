package com.ag04.Feeddit.services;

import com.ag04.Feeddit.entities.Article;
import com.ag04.Feeddit.repositories.ArticleRepository;
import com.ag04.Feeddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Article> getAllArticles(){

        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);

        return articles;
    }

    public void addNewArticle(String username, String headline, String link, String author) {

        Article article = new Article(userRepository.findOne(username), headline, link, author);

        System.out.println(userRepository.findOne(username));

        articleRepository.save(article);
    }
}
