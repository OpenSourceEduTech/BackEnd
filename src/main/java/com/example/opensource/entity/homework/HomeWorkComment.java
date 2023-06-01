package com.example.opensource.entity.homework;

import com.example.opensource.entity.lecture.Lecture;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class HomeWorkComment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private HomeWork homeWork;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;
}
