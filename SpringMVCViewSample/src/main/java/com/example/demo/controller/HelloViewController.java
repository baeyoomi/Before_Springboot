package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller          //RequestMapping 을 컨트롤할수 있게하는 - 어노테이션
@RequestMapping("hello")      //주소줄에 hello 를 입력하면 class HelloViewController 를 실행하렴
//@RequestMapping(value = { "hello", "hellospring" })
public class HelloViewController {
    @GetMapping("view")        //GetMapping 은 파라미터를 가짐, 안에있는 클래스를 실행하게해줌
    //@GetMapping( value = {"view", "viewspring" }) html이니까 소문자로 씀 , 아래 설명씀
    public String helloView(){
        return "hello";         //Control 에 대한 리턴값, hello.html 열어줌
    }

    @GetMapping( value = {"view2", "view2spring" })  // 복수형태에 문법, 둘 중 뭐로 입력하든 보여줌
    // @GetMapping("view2")
    public  String morning(){
        return  "morning";
    }
}

