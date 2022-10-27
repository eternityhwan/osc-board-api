package com.osckorea.board.service;

import com.osckorea.board.domain.dto.ArticleDto;
import com.osckorea.board.domain.entity.Article;
import com.osckorea.board.domain.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service // 서비스 선언 (서비스 객체를 스프링부트에 생성)
@Slf4j
public class ArticleService {

    // 서비스계층, 레스트컨트롤러와 레파지토리 사이의 계층
    // 트랜잭션 -- 모두 성공되어야하는 일련의 과정

    @Autowired // 의존성 주입
    private ArticleRepository articleRepository;

    // get all
    public List<Article> index() {
        return articleRepository.findAll();
    }
    // get id
    public Article findArticle(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // post
    public Article createArticle(ArticleDto dto) {
        // 1. dto를 받았으면 dto를 entity로 바꾸고
        // 1-1.Entity article 객체로 바꾼다
       Article articleEntity = dto.toEntity();
       // article가 null이 아니면 null을 반환해라
        // 수정이 안되게 아이디가 존재한다면 null을 반환해라 명령
       if (articleEntity.getId() != null) {
           return null;
       }
       // Entity 객체인 article 객체롤 DB에 저장하면된다
       return articleRepository.save(articleEntity);
    }


    public Article revision(Long id, ArticleDto dto) {
        //  1. 수정용 엔티티 생성
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        // 2. 대상 엔티티를 조회
        Article targetEntity = articleRepository.findById(id).orElse(null);

        // 3. 잘못된 요청 처리 (대상이 없거나, id가 다른경우)
        if (targetEntity == null || id != article.getId()) {
           log.info("잘못된 요청 : id: {}, article: {}", id, article.toString());
           return null;
        }
        // 4. 업데이트
        targetEntity.patch(article);
        Article updated = articleRepository.save(targetEntity);
        return updated;
    }


    public Article delete(Long id) {

        // 1. 대상 찾기
        Article targetEntity = articleRepository.findById(id).orElse(null);

        // 1-1 잘못된 요청 처리
        if (targetEntity == null) {
            return null;
        }

        // 2. 대상 삭제
        articleRepository.delete(targetEntity);
        return targetEntity;
    }

    @Transactional // 해당 메소드를 트랜잭션으로 묶는다.
                    // 진행하다 실패하면 메소드가 실행하기 전 상태로 롤백한다.
    public List<Article> createArticles(List<ArticleDto> dtos) {
        // dto 묶음을 entity 묶음으로 변환
        List<Article> articleEntityList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        // entity 묶음을 DB로 저장
        articleEntityList.stream()
                // forEach 하나하나 반복한다
                .forEach(article -> articleRepository.save(article));

        // 강제 예외 발생시킨다
        articleRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("결제 실패")
        );

        // 결과값 반환
        return null;
    }
}
