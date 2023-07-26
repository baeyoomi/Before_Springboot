package com.example.test.controller;

import com.example.test.entity.Board;
import com.example.test.form.BoardForm;
import com.example.test.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/board")
public class BoardController {
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
        model.addAttribute("boardlist",list);
        model.addAttribute("boardtitle","등록 서식");
        return "/sub3/boardmake";
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
            redirectAttributes.addFlashAttribute("boardcomplete","등록이 완료되었습니다.");
            return "redirect:/board";
        } else {
            //에러가 발생한 경우에는 목록 표시로 변경
            return showList(boardForm, model);
        }
    }

    private void makeUpdateModel(BoardForm boardForm, Model model){  ///makeUpdateModel(변경할거 ,변경한거)
        model.addAttribute("no",boardForm.getNo());
        boardForm.setNewBoard(false);
        model.addAttribute("boardForm", boardForm);
        model.addAttribute("boardtitle","변경 폼");
    }

    @PostMapping("/update")
    public String update(@Validated BoardForm boardForm, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        Board board = makeBoard(boardForm);

        //입력체크
        if (!result.hasErrors()){
            //변경 처리
            boardService.updateBoard(board);
            redirectAttributes.addFlashAttribute("boardcomplete","변경이 완료되었습니다.");
            // 변경 화면을 표시
            return "redirect:/board" + board.getNo();
        } else {
            //변경용 모델을 생성
            return "/sub3/boardmake";
        }
    }

    private Board makeBoard(BoardForm boardForm) {
        Board board = new Board();
        board.setNo(boardForm.getNo());
        board.setManager(boardForm.getManager());
        board.setTitle(boardForm.getTitle());
        board.setContents(boardForm.getContents());
        board.setDate(boardForm.getDate());
        board.setName(boardForm.getName());
        board.setPush(boardForm.getPush());
        board.setViews(boardForm.getViews());
        return board;
    }

    private BoardForm makeBoardForm(Board board) {
        BoardForm boardForm = new BoardForm();
        boardForm.setNo(board.getNo());
        boardForm.setManager(board.getManager());
        boardForm.setTitle(board.getTitle());
        boardForm.setContents(board.getContents());
        boardForm.setDate(board.getDate());
        boardForm.setName(board.getName());
        boardForm.setPush(board.getPush());
        boardForm.setViews(board.getViews());
        boardForm.setNewBoard(false);
        return boardForm;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") String no, Model model, RedirectAttributes redirectAttributes){
        boardService.deleteBoard(Integer.parseInt(no));
        redirectAttributes.addFlashAttribute("boarddelcomplate","삭제 완료했습니다.");
        return "redirect:/board";
    }



}
