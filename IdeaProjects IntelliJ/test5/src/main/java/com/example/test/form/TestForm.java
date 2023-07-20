package com.example.test.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data             //Get,Set
@NoArgsConstructor    //생성자
@AllArgsConstructor   //초기값형성
public class TestForm {
    private Integer id;

    @NotBlank
    private String question;

    private Integer answer;

    @NotBlank
    private String author;

    //등록 또는 변경을 판단하기 위해
    private Boolean newTest;
}
