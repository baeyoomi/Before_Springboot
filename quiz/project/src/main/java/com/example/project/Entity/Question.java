package com.example.project.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Setter
@Getter

public class Question {
    @Id
    private Integer id;

    private String subject;

    private String content;

    @Column(insertable = false, updatable = false, columnDefinition = "date default LOCALTIMESTAMP")
    private Date createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
