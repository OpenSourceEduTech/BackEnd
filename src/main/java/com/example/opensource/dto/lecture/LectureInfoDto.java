package com.example.opensource.dto.lecture;


import com.example.opensource.entity.lecture.Lecture;
import lombok.Data;

@Data
public class LectureInfoDto {

    private Long id;
    private String title;
    private String image;

    public LectureInfoDto(Lecture lecture) {
        this.id = lecture.getId();
        this.title = lecture.getTitle();
        this.image = lecture.getImage();
    }
}
