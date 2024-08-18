package com.example.springbootdeveloper.dto;

import com.example.springbootdeveloper.domain.Article;
import lombok.Getter;

@Getter
public class ArticleReponse {

    private final String title;
    private final String content;

    public ArticleReponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
