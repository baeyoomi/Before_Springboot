package com.example.test.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardForm {

    private Integer no;
    private String manager;
    private String title;
    private String contents;
    private String date;

    @NotBlank
    private String name;

    private Integer push;
    private Integer views;


    /* 등록 또는 변경 판단용 */
    private Boolean newBoard;
}
