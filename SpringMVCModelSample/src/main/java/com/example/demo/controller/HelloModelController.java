package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloModelController {
    @GetMapping("model") //타임리프에서 전달하는 변수들이 생기면 전달가능하게 하는 model interface
    public String helloView(Model model) {
        model.addAttribute("msg","타임리프!!!");    //변수명 msg 메시지
        model.addAttribute("name","배유미");
        model.addAttribute("name2","길동");
        return "helloThymeleaf";
    }
}
