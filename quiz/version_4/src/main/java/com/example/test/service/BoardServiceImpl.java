package com.example.test.service;

import com.example.test.entity.Board;
import com.example.test.repository.BoardRepository;
import com.example.test.repository.ClassBoardRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardRepository boardRepository;

    @Override
    public Optional<Board> selectBoardOneById(Integer no) {
        return boardRepository.findById(no);
    }

    @Override
    public Iterable<Board> selectAll() {
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> selectOneRandomBoard() {
        Integer randNo = boardRepository.getRandomNo();
        if (randNo == null) {
            return Optional.empty();
        }
        return boardRepository.findById(randNo);
    }

    @Override
    public void insertBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void updateBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Integer no) {
        boardRepository.deleteById(no);
    }

    public List<Board> findAllByPage(int size, String page){
        List<Board> boards = new ArrayList<>(); return boards;};
}
