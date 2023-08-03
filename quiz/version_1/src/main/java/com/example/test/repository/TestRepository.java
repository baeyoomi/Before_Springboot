package com.example.test.repository;

import com.example.test.entity.Test;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test,Integer> {
    @Query("SELECT id FROM test WHERE id > 0 order by id desc limit 1")  //4개
    //테스트에서 ID를 선택하십시오. ID > 0 순서는 ID 설명 제한 1로 지정합니다
    Integer getRandomId();
}
