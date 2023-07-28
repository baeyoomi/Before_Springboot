package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class BasicController {

    @GetMapping
    public String selectIndex(@PathVariable Integer number){
        String view = null;
        switch (number){
            case 1:
                view = "/sub1/login";
                break;
            case 2:
                view = "/sub2/qna";
            case 3:
                view = "/board";
                break;
            case 4:
                view = "/quiz/main";
                break;
            case 5:
                view = "/index";
                break;
        }
        return view;
    }
}
