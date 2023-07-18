package com.example.test.controller;
//지금까지한 MVC패턴 활용해봄
import com.example.test.entity.Test;
import com.example.test.form.TestForm;
import com.example.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
        //신규 등록 설정
        testForm.setNewTest(true);
        //퀴즈 목록 취득
        Iterable<Test> list = service.selectAll();
        //표시용 Model 에 저장
        model.addAttribute("list",list);
        model.addAttribute("title","등록 폼");
        return "crud";
    }

    @PostMapping("/insert")
    public String insert(@Validated TestForm testForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        // Form에서 Entity로 넣기
        Test test = new Test();
        test.setQuestion(testForm.getQuestion());
        test.setAnswer(testForm.getAnswer());
        test.setAuthor(testForm.getAuthor());

        //입력체크
        if (!bindingResult.hasErrors()){
            service.insertTest(test);
            redirectAttributes.addFlashAttribute("complete","등록이 완료되었습니다.");
            return "redirect:/test";
        } else {
            //에러가 발생한 경우에는 목록 표시로 변경
            return showList(testForm, model);
        }
    }

    @GetMapping("/{id}")
    public String showUpdate(TestForm testForm, @PathVariable Integer id, Model model){
        // Test 를 취득(Optional 로 래핑)
        Optional<Test> testOpt = service.selectOneById(id);

        // TestForm 에 채워넣기   , 화살표 함수 = 사용자 함수 지정할때 이름+파라미터+리턴값등 적는것대신 파라미터=리턴값 만 줌(이름없음)
        Optional<TestForm> testFormOpt = testOpt.map(t -> makeTestForm(t));

        // TestForm  이 null이 아니라면 값을 취득
        if(testFormOpt.isPresent()){
            testForm = testFormOpt.get();
        }

        //변경용 모델 생성
        makeUpdateModel(testForm,model);
        return "crud";

    }
    /* function move(x){return y * y;}, (x) => y * y; */
    private void makeUpdateModel(TestForm testForm, Model model){
        model.addAttribute("id",testForm.getId());
        testForm.setNewTest(false);
        model.addAttribute("testForm", testForm);
        model.addAttribute("title","변경 폼");
    }

    @PostMapping("/update")
    public String update(@Validated TestForm testForm, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        // TestForm에서 Test로 채우기
        Test test = makeTest(testForm);

        //입력체크
        if (!result.hasErrors()){
            //변경 처리, Flash scope를 사용해서 리다이렉트 설정
            service.updateTest(test);
            redirectAttributes.addFlashAttribute("complete","변경이 완료되었습니다.");
            // 변경 화면을 표시
            return "redirect:/test/" + test.getId();
        } else {
            //변경용 모델을 생성
            return "crud";
        }
    }
    /*
    a(10)라는 변수와 b(20)라는 변수를 서로 바꾸는 방법 a(20) b(10)
    temp(20) = b(20)
    b(10) = a(10)
    a(20) = temp(20)
    */

    private Test makeTest(TestForm testForm) {
        Test test = new Test();
        test.setId(testForm.getId());
        test.setQuestion(testForm.getQuestion());
        test.setAnswer(testForm.getAnswer());
        test.setAuthor(testForm.getAuthor());
        return test;
    }

    private TestForm makeTestForm(Test test) {
        TestForm form = new TestForm();
        form.setId(test.getId());
        form.setQuestion(test.getQuestion());
        form.setAnswer(test.getAnswer());
        form.setAuthor(test.getAuthor());
        form.setNewTest(false);
        return form;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") String id, Model model, RedirectAttributes redirectAttributes){
        //퀴즈 정보를 1건 삭제하고 리다이렉트
        service.deleteTestById(Integer.parseInt(id));
        redirectAttributes.addFlashAttribute("delcomplate","삭제 완료했습니다.");
        return "redirect:/test";
    }

    @GetMapping("/play")
    public String showTest(TestForm testForm, Model model){
        Optional<Test> testOpt = service.selectOneRandomTest();
        if(testOpt.isPresent()){
            // TestForm 으로 채우기
            Optional<TestForm> testFormOpt = testOpt.map(t -> makeTestForm(t));
            testForm = testFormOpt.get();
        } else {
            model.addAttribute("msg","등록된 문제가 없습니다");
            return "play";
        }
        model.addAttribute("testForm", testForm);

        return "play";
    }

    @PostMapping("/check")
    public String checkTest(TestForm testForm, @RequestParam Boolean answer, Model model){
        if(service.checkTest(testForm.getId(), answer)){
            model.addAttribute("msg","정답입니다.");
        } else {
            model.addAttribute("msg","오답입니다.");
        }
        return "answer";
    }
}
