package com.example.demo;

import com.example.demo.entity.Test;
import com.example.demo.repository.MemberCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class SpringDataJdbcSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcSampleApplication.class, args)
				.getBean(SpringDataJdbcSampleApplication.class).execute();
	}

	@Autowired
	MemberCrudRepository repository;
	//CrudRepository를 상속받은 인터페이스기 때문에 save(), findAll()과 같은 repository 메소드 사용가능

	private void execute() {
		executeInsert();
		executeSelect();
	}

	private void executeInsert() {
		// 엔티티 생성(id와 자동 부여되기 떄문에 null을 설정)
		Test test = new Test(null,"홍길동");
		// 리포지토리를 이용해서 등록 실행하고 결과를 취득
		test = repository.save(test);
		//결과를 표시
		System.out.println("등록 데이터" + test);
	}

	private void executeSelect() {
		System.out.println("--- 전체 데이터를 취득합니다 ---");
		// 리포지토리를 사용해서 전체 데이터를 취득
		Iterable<Test> tests = repository.findAll();
		for(Test test : tests) {
			System.out.println(test);
		}
	}
}
