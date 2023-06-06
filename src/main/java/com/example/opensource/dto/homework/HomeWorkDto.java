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
    private String filename;
    private String filePath;


    public HomeWorkDto(HomeWork homeWork) {
        this.filename = homeWork.getFilename();
        this.filePath = homeWork.getFilePath();
        this.id = homeWork.getId();
        this.title = homeWork.getTitle();
        this.content = homeWork.getContent();
    }
}
