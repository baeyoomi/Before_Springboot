package com.example.test.repository;

import com.example.test.entity.Board;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public interface BoardRepository extends CrudRepository<Board, Integer> {
    @Query("SELECT * FROM board ORDER BY no DESC LIMIT :size")
    Integer getRandomNo();

}