package com.example.opensource.dto.homework;

import com.example.opensource.entity.lecture.Lecture;
import lombok.Data;

@Data
public class MindMapDto {
    private String subject;

    public MindMapDto(Lecture lecture){
        this.subject = lecture.getTitle();
    }
}
