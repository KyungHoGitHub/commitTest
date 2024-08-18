package com.example.springbootdeveloper.controller;

import com.example.springbootdeveloper.domain.Article;
import com.example.springbootdeveloper.dto.AddArticleRequest;
import com.example.springbootdeveloper.dto.ArticleReponse;
import com.example.springbootdeveloper.service.Blogservice;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final Blogservice blogservice;

    /** 블로그 글 생성 */
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article saveArticle = blogservice.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveArticle);
    }

    /** 블로그 글목록 조회 */
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleReponse>> getAllArticles(){
        List<ArticleReponse> articles = blogservice.findAll()
                .stream()
                .map(ArticleReponse::new)
                .toList();

        return ResponseEntity.ok().body(articles);
    }

    /** 블로그 해당 글 조회 */
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleReponse> getArticleById(@PathVariable Long id){
       Article article = blogservice.findById(id);
       return ResponseEntity.ok().body(new ArticleReponse(article));
    }

}
