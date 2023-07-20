package com.example.demo.controller;

import com.example.demo.form.CalcForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {
    /* form-backing bean 초기화 */
    @ModelAttribute      //요 어노테이션이랑 클래스 부분이 중요
    public CalcForm setUpForm() {
        return new CalcForm();
    }

    @GetMapping("show")
    public String showView(){
        return "entry";
    }

    @PostMapping("calc")
    public String confirmView(@Validated CalcForm form, BindingResult bindingResult, Model model){  //BindingResult 유효성 검사 인터페이스를 사용할수 있음
        if(bindingResult.hasErrors()){   //에러가 났을 경우
            return "entry";              //entry로 돌아가라
        }

        Integer result = form.getLeftNum() + form.getRightNum();   //선언하고
        model.addAttribute("result",result);           //사용할 수 있게 하기

        return "confirm";
    }
}
