package com.example.test.controller;

import com.example.test.entity.Board;
import com.example.test.entity.Test;
import com.example.test.form.BoardForm;
import com.example.test.form.TestForm;
import com.example.test.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/boardmain")
public class BoardmainController {
    @Autowired
    BoardService boardService;

    @ModelAttribute
    public BoardForm setUpForm(){
        BoardForm boardForm = new BoardForm();
        return boardForm;
    }

    @GetMapping
    private String showList(BoardForm boardForm, Model model){
        //신규 등록 설정
        boardForm.setNewBoard(true);

        //목록 취득
        Iterable<Board> list = boardService.selectAll();

        //표시용 Model 에 저장
        model.addAttribute("mainlist",list);
        model.addAttribute("maintitle","등록 서식");
        return "/sub3/boardmain";
    }
    @PostMapping("/insert")
    public String insert(@Validated BoardForm boardForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        Board board = new Board();
        board.setNo(boardForm.getNo());
        board.setManager(boardForm.getManager());
        board.setTitle(boardForm.getTitle());
        board.setContents(boardForm.getContents());
        board.setDate(boardForm.getDate());
        board.setName(boardForm.getName());
        board.setPush(boardForm.getPush());
        board.setViews(boardForm.getViews());

        //입력체크
        if (!bindingResult.hasErrors()){
            boardService.insertBoard(board);
            return "redirect:/boardmain";
        } else {
            //에러가 발생한 경우에는 목록 표시로 변경
            return showList(boardForm, model);
        }
    }


}
