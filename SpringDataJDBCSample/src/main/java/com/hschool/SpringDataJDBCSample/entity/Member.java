package com.hschool.SpringDataJDBCSample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data   //클래스에 부여하는 것(어노테이션), 전 필드에 대해 getter/setter를 엑세스 할 수 있다. hashCode(), equals(), toString()도 사용가능 // (여러부분에 부여할 수 있음, 지금은 클래스에 부여함)
@NoArgsConstructor // 클래스에 부여하는 것, 기본 생성자가 자동 생성된다.
@AllArgsConstructor // 클래스에 부여하는 것, 전 필드에 대해 초기화 값을 인수로 가지는 생성자가 자동 생성된다.
public class Member {
    @Id
    private Integer id;
    private String name;


}
