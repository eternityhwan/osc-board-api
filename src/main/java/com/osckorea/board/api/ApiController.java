package com.osckorea.board.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //  RestAPI용 컨트롤러 json을 반환
public class ApiController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello world";
    }
}
