package com.example.opensource.entity.lecture;

import com.example.opensource.entity.homework.HomeWork;
import com.example.opensource.entity.homework.HomeWorkComment;
import com.example.opensource.entity.notice.Notice;
import com.example.opensource.entity.notice.NoticeComment;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String image;

    @OneToMany(mappedBy = "lecture")
    private List<UserConLec> lectureList = new ArrayList<>();

    @OneToMany(mappedBy = "lecture")
    private List<SecretBoard> secertBoardList = new ArrayList<>();

    @OneToMany(mappedBy = "lecture")
    private List<Notice> noticeList = new ArrayList<>();

    @OneToMany(mappedBy = "lecture")
    private List<HomeWork> homeWorkList = new ArrayList<>();






}
