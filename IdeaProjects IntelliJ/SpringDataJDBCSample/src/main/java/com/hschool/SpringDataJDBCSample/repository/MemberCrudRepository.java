package com.hschool.SpringDataJDBCSample.repository;

import com.hschool.SpringDataJDBCSample.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberCrudRepository extends CrudRepository<Member, Integer> {    //<Member, Integer> = 필드명, id / CRUD = DML = 데이터 조작 언어

}
