package com.osckorea.board.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MustacheController {
    
    @GetMapping(value = "/hi")
    public String mustacheCon(Model model) {
        model.addAttribute("username", "rok");
        return "greetings";
    }

    @GetMapping(value = "/bye")
    public String sangilPage(Model model) {
        model.addAttribute("sangil", "김민준");
        return "bye";
    }
}
