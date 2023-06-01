package com.example.opensource.entity.lecture;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;
}
