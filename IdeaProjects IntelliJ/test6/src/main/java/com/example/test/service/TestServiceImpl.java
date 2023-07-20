package com.example.test.service;

import com.example.test.entity.Test;
import com.example.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TestServiceImpl implements TestService{

    //Autowired 꼭 써줘야 사용가능
    @Autowired
    TestRepository repository;


    // 하위 오버라이드 내용 리턴값 변경함
    @Override
    public Iterable<Test> selectAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Test> selectOneById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Test> selectOneRandomTest() {
        Integer randId = repository.getRandomId();
        if (randId == null){
            return Optional.empty();
        }
        return repository.findById(randId);
    }

    @Override
    public Boolean checkTest(Integer id, Integer myAnswer) {
        Boolean check = false;
        Optional<Test> optTest = repository.findById(id);
        if (optTest.isPresent()) {
            Test test = optTest.get();
            if(test.getAnswer().equals(myAnswer)) {
                check = true;
            }
        }
        return check;
    }


    @Override
    public void insertTest(Test test) {
        repository.save(test);
    }

    @Override
    public void updateTest(Test test) {
        repository.save(test);
    }

    @Override
    public void deleteTestById(Integer id) {
        repository.deleteById(id);
    }
}
