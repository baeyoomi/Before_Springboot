package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Timestamp;

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


    /*새로 만듬*/
    public void setContent(String content) {    }

    public void setCreatedAt(Timestamp createdAt) {    }

    public void setUpdatedAt(Timestamp updatedAt) {    }
    private Long number;
    private String titles;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer page;
}
