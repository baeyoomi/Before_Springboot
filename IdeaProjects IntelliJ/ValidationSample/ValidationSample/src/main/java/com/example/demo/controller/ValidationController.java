package com.example.demo.controller;

import com.example.demo.form.CalcForm;
import com.example.demo.validator.CalcValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {
    //유효성 검사를 하기 위해서는 form-backing bean 설정이 필요함.
    //<form> 태그 안에 input 의 name="id" value="ashram7" 바인딩 되어서
    //form 클래스 인스턴스(form-backing bean)라고 부르고, 이것을 초기화 한 것이다.
    //@ModelAttribute 어노테이션을 부여해서 사용한다.
    @ModelAttribute         //model 변수값 전달, form-backing bean 초기화 ,  오늘배운 이 아래 부분 공식임
    public CalcForm setUpForm(){
        return new CalcForm();           //CalcForm 생성자 , ctrl 누르고 클릭하면 연결된곳으로 이동함
    }
    @GetMapping("show")
    public String showView(){
        return "entry";
    }

    @PostMapping("calc")
    public String conformView(@Validated CalcForm form, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "entry";
        }
        Integer result = form.getLeftNum() + form.getRightNum();
        model.addAttribute("result",result);
        return "confirm";
    }

    @Autowired
    CalcValidator calcValidator;

    @InitBinder("calcForm")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(calcValidator);
    }

}
