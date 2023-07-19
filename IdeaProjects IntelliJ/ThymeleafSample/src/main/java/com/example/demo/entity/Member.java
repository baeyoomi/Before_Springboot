package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data       // Getter,Setter 를 생성해줌 (Private 속성인 객체에 접근하기 위해 사용)
@AllArgsConstructor     // 전체 필드에 대한 초깃값을 인수로 받는 생성자를 생성
public class Member {
    private Integer id;
    private String name;
    //상단에 @Data 어노테이션을 사용해서  get,set 안만들어줘도 됌
}
