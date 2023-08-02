package com.example.project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Setter
@Getter
public class Answer {
    @Id
    private Integer id;

    private String content;

    @Column(insertable = false, updatable = false, columnDefinition = "date default LOCALTIMESTAMP")
    private Date createDate;

    @ManyToOne
    private Question question;

}