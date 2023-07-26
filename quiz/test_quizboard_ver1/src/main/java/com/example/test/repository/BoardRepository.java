package com.example.test.repository;

import com.example.test.entity.Board;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Integer> {
    @Query("SELECT * FROM board ORDER BY NO")
    Integer getRandomNo();
}
