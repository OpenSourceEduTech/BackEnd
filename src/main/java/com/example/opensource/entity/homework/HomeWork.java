package com.example.opensource.entity.homework;

import com.example.opensource.dto.homework.HomeWorkDto;
import com.example.opensource.entity.lecture.Lecture;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class HomeWork {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String startDate;
    private String EndDate;
    private int score;
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;

    @OneToMany(mappedBy = "homework")
    private List<HomeWorkComment> homeWorkCommentList = new ArrayList<>();

    //생성자
    public HomeWork(HomeWorkDto homeWorkDto, Lecture lecture){
        this.title = homeWorkDto.getTitle();
        this.content = homeWorkDto.getContent();
        this.lecture = lecture;
    }

    public void addFilePath(String filePath) {
        this.filePath = filePath;
    }

}
