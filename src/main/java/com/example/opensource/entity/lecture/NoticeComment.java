package com.example.opensource.entity.lecture;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class NoticeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notice notice;
}
