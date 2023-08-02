package com.example.project.controller;

import com.example.project.Entity.Question;
import com.example.project.repository.QuestionRepository;
import com.example.project.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @RequestMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @RequestMapping(value = "/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        return "question_detail";
    }
}