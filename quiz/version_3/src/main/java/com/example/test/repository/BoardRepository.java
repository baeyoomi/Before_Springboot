package com.example.test.repository;

import com.example.test.entity.Board;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public interface BoardRepository extends CrudRepository<Board, Integer> {
    @Query("SELECT no FROM board ORDER BY no ASC limit 1")
    Integer getRandomNo();

    public List<Board> findAllByPage(int page, int size);
}