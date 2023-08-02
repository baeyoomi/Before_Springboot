package com.example.test.service;

import com.example.test.entity.Board;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface BoardService {
    /*등록된 모든 게시물 정보를 가져옵니다*/
    Iterable<Board> selectAll();

    Optional<Board> selectOneRandomBoard();

    Optional<Board> selectBoardOneById(Integer no);

    /*게시물을 등록합니다*/
    void insertBoard(Board board);


    /*게시물을 변경합니다*/
    void updateBoard(Board board);

    /*게시물을 삭제합니다*/
    void deleteBoard(Integer no);


}
