package com.ag04.Feeddit.repositories;

import com.ag04.Feeddit.entities.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

    public List<Article> findByUserUsername(String username);
}
