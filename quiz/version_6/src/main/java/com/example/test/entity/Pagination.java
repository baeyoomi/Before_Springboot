package com.example.test.entity;

import lombok.Data;

@Data
public class Pagination {
    //표시돼는 페이지수
    private int viewPages = 10;
    //전체페이지수
    private int totalPage;
    //한화면에 시작페이지번호
    private int startPage;
    //한화면에 끝페이지번호
    private int endPage;
    //현재 페이지번호
    private int nowPage;

    //다음 블락구간
    private int next = -1;
    //이전 블락구간
    private int previous = -1;

    public Pagination(int total,int size, int page) {
        this.totalPage = total/size+1;

        this.startPage = ((int)(size*page) / (size*viewPages)) *viewPages + 1;
        this.endPage  = Math.min(total/size+1, startPage+(viewPages-1));

        this.nowPage = page;
        //페이지수별 구간  다음 11, 21 ...
        if(startPage > 1) this.previous = startPage - viewPages-1;
        if(endPage < totalPage) this.next = endPage ;
    }
}

