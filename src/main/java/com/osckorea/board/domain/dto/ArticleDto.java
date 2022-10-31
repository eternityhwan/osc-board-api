package com.osckorea.board.domain.dto;

import com.osckorea.board.domain.entity.Article;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleDto {

    private Long id;
    private String title;
    private String content;

    // Dto를 Entity로 반환해주는 메서드.
    public Article toEntity() {
        return new Article(id, title, content);
    }
}

