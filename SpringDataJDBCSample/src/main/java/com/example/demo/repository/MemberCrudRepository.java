package com.example.demo.repository;

import com.example.demo.entity.Test;
import org.springframework.data.repository.CrudRepository;

public interface MemberCrudRepository extends CrudRepository<Test, Integer> {   //<Test(entity에 만든 클래스Test), Integer(그 안에 primary키를 가진 Integer를 입력)>

}
