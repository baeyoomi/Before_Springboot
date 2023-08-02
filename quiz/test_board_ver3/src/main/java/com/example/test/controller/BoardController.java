package com.example.test.controller;

import com.example.test.entity.Board;
import com.example.test.entity.Test;
import com.example.test.form.BoardForm;
import com.example.test.form.TestForm;
import com.example.test.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
        model.addAttribute("mainlist",list);
        model.addAttribute("maintitle","등록 서식");
        return "sub3/board";
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
            return "redirect:/board";
        } else {
            //에러가 발생한 경우에는 목록 표시로 변경
            return showList(boardForm, model);
        }
    }


    @PostMapping("/contents")
    public String content(@Validated BoardForm boardForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        Board board = new Board();
        board.setNo(boardForm.getNo());
        board.setManager(boardForm.getManager());
        board.setTitle(boardForm.getTitle());
        board.setContents(boardForm.getContents());
        board.setDate(boardForm.getDate());
        board.setName(boardForm.getName());
        board.setPush(boardForm.getPush());
        board.setViews(boardForm.getViews());
        return "sub3/boardcontents";
    }


    @GetMapping("/contents/{no}")
    public String showView(BoardForm boardForm, @PathVariable Integer no, Model model){
        Optional<Board> boardOpt = boardService.selectBoardOneById(no);

        Optional<BoardForm> boardFormOpt = boardOpt.map(t -> makeBoardForm(t));

        if(boardFormOpt.isPresent()){
            boardForm = boardFormOpt.get();
        }

        makeUpdateModel(boardForm,model);
        return "sub3/boardcontents";
    }

    @GetMapping("/{no}")
    public String showUpdate(BoardForm boardForm, @PathVariable Integer no, Model model){
        Optional<Board> boardOpt = boardService.selectOneRandomBoard();

        Optional<BoardForm> boardFormOpt = boardOpt.map(t -> makeBoardForm(t));

        if(boardFormOpt.isPresent()){
            boardForm = boardFormOpt.get();
        }

        makeUpdateModel(boardForm,model);
        return "redirect:/boardmake";

    }
    private void makeUpdateModel(BoardForm boardForm, Model model){
        model.addAttribute("no",boardForm.getNo());
        boardForm.setNewBoard(false);
        model.addAttribute("boardForm", boardForm);
        model.addAttribute("title","변경 폼");
    }
    private BoardForm makeBoardForm(Board board) {
        BoardForm form = new BoardForm();
        form.setNo(board.getNo());
        form.setManager(board.getManager());
        form.setTitle(board.getTitle());
        form.setContents(board.getContents());
        form.setDate(board.getDate());
        form.setName(board.getName());
        form.setPush(board.getPush());
        form.setViews(board.getViews());
        return form;
    }

/*    @Select({"SELECT NVL(MAX(no),0) FROM board WHERE no < #{no}"})
    public int prevPage(@Param("no")int no);
    @Select({"SELECT NVL(MIN(no),0) FROM board WHERE no > #{no}"})
    public int nextPage(@Param("no")int no);*/


}
