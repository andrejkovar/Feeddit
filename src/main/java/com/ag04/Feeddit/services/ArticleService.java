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

    public List<Article> getAllArticles(){

        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);

        return articles;
    }
}
