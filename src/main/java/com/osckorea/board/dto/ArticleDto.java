package com.osckorea.board.dto;

import com.osckorea.board.entity.Article;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleDto {

    private Long id;
    private String title;
    private String content;
    
    public Article toEntity() {
        return new Article(id, title, content);
        // Entity 클래스의 객체 Article 선언
        // id 값은 null을 주고 dto를 그대로 가져온다.
    }
}

