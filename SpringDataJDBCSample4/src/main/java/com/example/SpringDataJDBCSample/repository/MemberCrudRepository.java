package com.example.SpringDataJDBCSample.repository;

import com.example.SpringDataJDBCSample.entity.Test;
import com.example.SpringDataJDBCSample.entity.Test;
import org.springframework.data.repository.CrudRepository;

public interface MemberCrudRepository extends CrudRepository<Test, Integer> {

}
