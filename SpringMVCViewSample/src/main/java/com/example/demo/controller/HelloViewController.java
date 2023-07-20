package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloViewController {
    @GetMapping("view")     //http://localhost:8080/hello/view
    public String helloView() {
        return "hello";
    }

    @GetMapping("view2")
    public String morning() {
        return "morning";
    }

}
