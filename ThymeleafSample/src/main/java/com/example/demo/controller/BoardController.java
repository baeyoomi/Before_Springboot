package com.example.demo.controller;

import com.example.demo.entity.Crew;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hi")
public class BoardController {
    @GetMapping("b")
    public String showB(){
        return "board";
    }
}
