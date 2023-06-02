package com.example.opensource.entity.notice;

import com.example.opensource.entity.lecture.Lecture;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;

    @OneToMany(mappedBy = "notice")
    private List<NoticeComment> noticeCommentList = new ArrayList<>();
}
