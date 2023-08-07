package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    private Integer id;

    private String question;
    private Integer answer;

    private String author;

    private String optiona;
    private String optionb;
    private String optionc;
    private String optiond;
    private String answers;
}
