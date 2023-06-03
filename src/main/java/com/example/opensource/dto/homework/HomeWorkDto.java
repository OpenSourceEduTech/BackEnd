package com.example.opensource.dto.homework;

import com.example.opensource.entity.homework.HomeWork;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HomeWorkDto {
    private Long id;
    private String title;
    private String content;


    public HomeWorkDto(HomeWork homeWork) {
        this.id = homeWork.getId();
        this.title = homeWork.getTitle();
        this.content = homeWork.getContent();
    }
}
