package com.example.test.repository;

import com.example.test.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Integer> {
    @Query("SELECT no FROM board ORDER BY no ASC limit 1")
    Integer getRandomNo();
    @Transactional
    List<Board> findAll();
}
