package com.example.test.service;

import com.example.test.entity.Test;

import java.util.Optional;


public interface TestService {
    //등록된 모든 퀴즈 정보를 가져온다.      (Iterable<Test> DB 라고 보면됌)
    Iterable<Test> selectAll();

    //id를 키로 사용해 퀴즈 정보를 한 건 가져온다. (Optional<Test> DB 라고 보면됌)
    Optional<Test> selectOneById(Integer id);

    //퀴즈 정보를 랜덤으로 한건 가져온다
    Optional<Test> selectOneRandomTest();

    //데이터의 true false 여부를 판단
    Boolean checkTest(Integer id, Integer myAnswer);

    //퀴즈등록
    void insertTest(Test test);
    //퀴즈변경
    void updateTest(Test test);
    //퀴즈삭제
    void deleteTestById(Integer id);
}
