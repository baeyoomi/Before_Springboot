package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Crew {
    private Integer no;
    private String manager;
    private String title;
    private String name;
    private Integer push;
    private Integer views;
}
