package com.osckorea.board.controller;

import com.osckorea.board.domain.dto.ArticleDto;
import com.osckorea.board.domain.entity.Article;
import com.osckorea.board.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // RestAPI 용 컨트롤러, 데이터(json)를 변환
@Slf4j
@RequestMapping(value = "/api/boards") // /api 가 모든 url에 공통
@Tag(name = "Board API", description = "OSC KOREA BOARD API")
public class BoardApiController {

    @Autowired // DI 생성 객체를 가져와 연결.
    private ArticleService articleService;

    // FinAll Get
    @GetMapping(value = "")
    @Operation(summary = "글 리스트 출력", description = "테이블에 있는 모든 데이터를 출력")
    public List<Article> index() {
        return articleService.index();
    }

    // Get by id
    @GetMapping(value = "/{id}")
    @Operation(summary = " 개별 글 출력", description = "테이블에 있는 개별 데이터를 출력")
    public Article findArticle(@PathVariable Long id) {
        return articleService.findArticle(id);
    }

    // POST
    // @RequsestBody로 Dto 클래스를 받는다
    @PostMapping(value = "/posts")
    @Operation(summary = "글 추가", description = "테이블에 데이터를 추가")
    public ResponseEntity<Article> createArticle(@RequestBody ArticleDto dto) {
        Article posts = articleService.createArticle(dto);
        return (posts != null) ?
                ResponseEntity.status(HttpStatus.OK).body(posts) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Put
    @PutMapping(value = "/{id}")
    @Operation(summary = "개별 글 수정", description = "개별 데이터를 수정")
    public ResponseEntity<Article> update(
            @PathVariable Long id,
            @RequestBody ArticleDto dto) {
        // 서비스에게 update 메소드를 시킨다(파라메터 id와 dto를 넘겨준다)
        // updated 객체로 넘겨준다.
        // Controller는 Controller의 코드만 가지고 있는다.
        // 뭘 받고 뭘 리턴하는지만 알면 된다.
        Article updated = articleService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        // 굿 요청 ResponseEntity 상태 ok를 넣어주고 body에 update 객체를 반환해준다.
        // 배드 요청 ResponseEntity 상태 bad를 넣고 몸통없이 빌드해서 보여주면된다.
    }

    // DELETE
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "데이터 삭제", description = "개별 데이터 삭제")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Article deleted = articleService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

