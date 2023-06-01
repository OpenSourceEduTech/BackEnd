package com.example.opensource.entity.homework;

import com.example.opensource.entity.lecture.Lecture;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class HomeWork {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;
    private String startDate;
    private String EndDate;
    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;

    @OneToMany(mappedBy = "homework")
    private List<HomeWorkComment> homeWorkCommentList = new ArrayList<>();

}
