package com.example.opensource.dto.homework;

import com.example.opensource.entity.homework.HomeWork;
import lombok.Data;

@Data
public class HomeWorkDto {
    private String title;
    private String content;


    public HomeWorkDto(HomeWork homeWork) {
        this.title = homeWork.getTitle();
        this.content = homeWork.getContent();
    }
}