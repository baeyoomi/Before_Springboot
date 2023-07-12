package com.example.demo.controller;

import com.example.demo.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class ThymeleafController {
    @GetMapping("show")
    public String showView(Model model){
        Member member = new Member(1,"회원01");

        // Model1에 데이터를 추가
        // model.addAttribute(attributeName:"name",attributeValue:"이순신");   // 변수명, 변수값
        model.addAttribute("name","이순신");
        model.addAttribute("mb",member);
        return  "useThymeleaf";
    }
}
