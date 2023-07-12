package com.example.demo.controller;

import com.example.demo.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hello")
public class ThymeleafController {
    @GetMapping("a")
    public String showA(){
        return "pageA";
    }

    @GetMapping("show")
    public String showView(Model model){
        Member member = new Member(1,"회원01");

        // Model1에 데이터를 추가
        // model.addAttribute(attributeName:"name",attributeValue:"이순신");   // 변수명, 변수값
        //model.addAttribute("name","이순신");
        //model.addAttribute("mb",member);

        //0712 새로배우는 것
        //ArrayList, HashMap, List, Map
        Member member1 = new Member(10,"홍길동");
        Member member2 = new Member(20,"이영희");

        //List 생성
        List<String> directionList = new ArrayList();
        directionList.add("동");
        directionList.add("서");
        directionList.add("남");
        directionList.add("북");

        //Map 을 생성해서 Member 를 저장
        Map<String, Member> memberMap = new HashMap<>();
        memberMap.put("hong", member1);
        memberMap.put("lee", member2);

        //List 를 생성해서 Member 를 저장 -List 와 Map 이 합쳐진 형태 ArrayList(여러 타입 넣을 수 있음)
        List<Member> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);


        //Model 에 데이터를 추가
        model.addAttribute("name","이순신");
        model.addAttribute("mb",member);
        model.addAttribute("list",directionList);
        model.addAttribute("map",memberMap);
        model.addAttribute("members",memberList);

        return  "useThymeleaf";
    }
}
