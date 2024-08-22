package com.example.springbootdeveloper.service;

import com.example.springbootdeveloper.domain.Article;
import com.example.springbootdeveloper.dto.AddArticleRequest;
import com.example.springbootdeveloper.dto.UpdateArticleRequest;
import com.example.springbootdeveloper.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Blogservice {

    private final BlogRepository blogRepository;

    // Articel 등록 메소드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    // 물건 목록 조회 메소드
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    // id 값으로 특정 Article 값 조회
    public Article findById(Long id){
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found"));
    }

    // id 값으로 특정 Article 레코드 제거
    public void delete(Long id){
        blogRepository.deleteById(id);
    }

    // Article 값 수정 메소드
    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("id not found" + id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
