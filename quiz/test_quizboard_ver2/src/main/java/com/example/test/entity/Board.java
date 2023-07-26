package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    private Integer no;
    private String manager;
    private String title;
    private String contents;
    private String date;

    private String name;

    private Integer push;
    private Integer views;
}
