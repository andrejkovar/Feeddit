package com.ag04.Feeddit.repositories;

import com.ag04.Feeddit.entities.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
