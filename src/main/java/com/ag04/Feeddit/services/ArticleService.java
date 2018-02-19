package com.ag04.Feeddit.services;

import com.ag04.Feeddit.entities.Article;
import com.ag04.Feeddit.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserService userService;

    public List<Article> getAllArticles(){

        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles :: add);

        return articles;
    }

    public List<Article> getArticlesByUsername(String username){

        List<Article> articles = new ArrayList<>();
        articles.addAll(articleRepository.findByUserUsername(username));

        return articles;
    }

    public void addNewArticle(String username, String headline, String link, String author) {

        Article article = new Article(userService.getUser(username), headline, link, author);

        articleRepository.save(article);
    }

    public void deleteArticleById(int id) {
        articleRepository.delete(id);
    }

    public boolean isArticleExists(int id) {
        return articleRepository.exists(id);
    }

    public Article getArticleById(int id) {
        return articleRepository.findOne(id);
    }

    public void save(Article article) {
        articleRepository.save(article);
    }
}
