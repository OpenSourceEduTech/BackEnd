package com.example.opensource.entity.notice;

import com.example.opensource.dto.notice.NoticeDto;
import com.example.opensource.entity.lecture.Lecture;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;

    @OneToMany(mappedBy = "notice")
    private List<NoticeComment> noticeCommentList = new ArrayList<>();

    public Notice(NoticeDto noticeDto, Lecture lecture){
        this.title = noticeDto.getTitle();
        this.content = noticeDto.getContent();
        this.lecture = lecture;
    }
}
