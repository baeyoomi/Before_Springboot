package com.example.test.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestForm {

    /* 식별 ID */
    private Integer id;

    /* 퀴즈 내용 */
    @NotBlank
    private String question;

    /* 퀴즈 해답 */
    private Integer answer;

    /* 작성자 */
    @NotBlank
    private String author;

    private String optiona;
    private String optionb;
    private String optionc;
    private String optiond;

    /* 등록 또는 변경 판단용 */
    private Boolean newTest;
}