package com.example.test.controller;
//지금까지한 MVC패턴 활용해봄
import com.example.test.entity.Test;
import com.example.test.form.TestForm;
import com.example.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService service;      //의존성 주입

    @ModelAttribute
    public TestForm setUpForm(){
        TestForm form = new TestForm();
        //라디오 버튼의 초깃값 설정
        form.setAnswer(true);
        return form;
    }

    //Test 목록 표시
    @GetMapping
    private String showList(TestForm testForm, Model model){
        //신규등록 설정
        Iterable<Test> list = service.selectAll();
        //표시용 Model 에 저장
        model.addAttribute("list",list);
        model.addAttribute("title","등록 폼");
        return "crud";
    }
}
