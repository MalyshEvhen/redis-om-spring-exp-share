package com.example.demoredisom2.repository;

import com.example.demoredisom2.entity.Article;
import com.redis.om.spring.repository.RedisDocumentRepository;

public interface ArticleRepository extends RedisDocumentRepository<Article, String> {
    Iterable<Article> search(String q);
}
