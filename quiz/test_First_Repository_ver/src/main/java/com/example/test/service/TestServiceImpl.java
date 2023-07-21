package com.example.test.service;

import com.example.test.entity.Test;
import com.example.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TestServiceImpl implements TestService{
    @Autowired
    TestRepository repository;

    @Override
    public Iterable<Test> selectAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Test> selectOneById(Integer id) {
        return repository.findById(id);
    }

    /* 이 부분 중요 */
    @Override
    public Optional<Test> selectOneRandomTest() {
        Integer randId = repository.getRandomId();
        if (randId == null) {
            return Optional.empty();
        }
        return repository.findById(randId);
    }

    @Override
    public Boolean checkTest(Integer id, Integer myAnswer) {
        Boolean check = false;   //여기 안에서 사용하고 없어짐
        Optional<Test> optTest = repository.findById(id);   //오답인지 아닌지 판단할 키=id
        if (optTest.isPresent()) {
            Test test = optTest.get();
            //퀴즈 정답 확인
            if(test.getAnswer().equals(myAnswer)) {
                check = true;
            }
        }
        return check;
    }

    @Override
    public void updateTest(Test test) {
        repository.save(test);
    }

    @Override
    public void insertTest(Test test) {
        repository.save(test);
    }

    @Override
    public void deleteTestById(Integer id) {
        repository.deleteById(id);
    }
}
