package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data                   //get,set
@NoArgsConstructor      //생성자 자동 생성
@AllArgsConstructor     //생성자 초기화
public class Test {
    @Id   //자동증가
    private Integer id;
    private String author;
}
