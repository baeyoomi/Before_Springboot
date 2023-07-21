package com.example.test.repository;

import com.example.test.entity.Test;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test,Integer> {
    @Query("SELECT id FROM test ORDER BY RAND() limit 1")
        //sql 문으로 사용하는데 maria db 연결했으니 마리아 db 에서 사용하는 명령어 사용
        // RANDOM 은 maria 에서 사용안함, 이 문장은 랜덤으로 하나를 뽑아서 보여달라고 씀
    Integer getRandomId();
}
