package com.example.demo;

import com.example.demo.entity.Test;
import com.example.demo.repository.MemberCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJdbcSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run
						(SpringDataJdbcSampleApplication.class, args)
				.getBean(SpringDataJdbcSampleApplication.class).execute();
	}

	@Autowired
	MemberCrudRepository repository;
	private void execute(){
		executeInsert();
		executeSelect();
	}

	private void executeInsert(){
		Test test = new Test(null,"이순신");
		test = repository.save(test);
		System.out.println("등록 데이터: " + test);
	}

	private void executeSelect(){
		System.out.println("---전체 데이터를 실행합니다---");
		//
		Iterable<Test> members = repository.findAll();
		for(Test test : members){
			System.out.println(test);
		}
	}
}
