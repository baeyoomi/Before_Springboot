package com.example.test;

import com.example.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {SpringApplication.run(TestApplication.class, args);}

	@Autowired
	TestService service;

}
