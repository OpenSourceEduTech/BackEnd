package com.example.opensource.dto.lecture;


import com.example.opensource.entity.lecture.SecretBoard;
import lombok.Data;

@Data
public class SecretBoardListDto {
    private String title;
    private String content;

    //list 값 넣기
    public SecretBoardListDto (SecretBoard secretBoard){
        this.title = secretBoard.getTitle();
        this.content = secretBoard.getContent();
    }
}
