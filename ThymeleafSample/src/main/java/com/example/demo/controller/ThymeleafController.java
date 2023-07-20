package com.example.demo.controller;

import com.example.demo.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {          // 최상위 객체, ex)javascript = window
    @GetMapping("a")
    public String showA(){
        return "pageA";
    }

    @GetMapping("show")
    public String showView(Model model) {
        Member member = new Member(1, "회원01");


        model.addAttribute("name","이순신"); //스프링 클래스 model attribute 에 값넣기
        model.addAttribute("mb",member);  //스프링 클래스 model attribute 에 자바클래스 member 넣기

        Member member1 = new Member(10, "홍길동");
        Member member2 = new Member(20, "이영희");

        List<String> directionList = new ArrayList();    //   <>제네릭 괄호로 타입을 결정
        directionList.add("동");
        directionList.add("서");
        directionList.add("남");
        directionList.add("북");

        Map<String, Member> memberMap = new HashMap<>();     // <키, 쌍> ex)게시판 리스트
        memberMap.put("hong", member1);
        memberMap.put("lee", member2);

        List<Member> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);

        /* 위에 선언한걸 사용하려면 model attribute 에 추가한다 */
        model.addAttribute("list",directionList);
        model.addAttribute("map",memberMap);
        model.addAttribute("members",memberList);




        return "useThymeleaf";
    }
}
