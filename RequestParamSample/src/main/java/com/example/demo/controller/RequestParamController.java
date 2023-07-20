package com.example.demo.controller;

import com.example.demo.form.Form;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class RequestParamController {
    @GetMapping("show")
    public String showView() {
        return "entry";
    }

/*
   @PostMapping("confirm")
   public String confirmView(
            Model model,
            @RequestParam String name,
            @RequestParam Integer age,
            @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate birth) {
        Model 사용이유 : addAttribute 사용하려고, RequestParam 을 사용하여 html 에서 POST 형식으로 데이터를 받을 녀석을 가져옴
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("birth",birth);

        return "confirm";
    }
    http://localhost:8080/show 에서 내용 입력후 나오는 confirm 화면
*/

    @PostMapping("confirm")     //위랑 다르게 클래스 만들어주고 매핑
    public String confirmView(Form f) {
        return "confirm2";
    }
}

