package com.example.test.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data             //Get,Set
@NoArgsConstructor    //생성자
@AllArgsConstructor   //초기값형성
public class TestForm {
    private Integer id;

    @NotBlank
    private String question;

    private Boolean answer;

    @NotBlank
    private String author;

    private String answerqueA;
    private String answerqueB;
    private String answerqueC;
    private String answerqueD;

    //등록 또는 변경을 판단하기 위해
    private Boolean newTest;
}
