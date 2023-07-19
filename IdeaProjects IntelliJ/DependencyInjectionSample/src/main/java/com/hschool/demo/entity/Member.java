package com.hschool.demo.entity;

public class Member {        //레파지토리 = 데이터베이스와 class를 연결하는 파일, 엔티티 = 객체, 레코드
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
