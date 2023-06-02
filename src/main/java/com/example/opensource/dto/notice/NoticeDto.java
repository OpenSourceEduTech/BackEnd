package com.example.opensource.dto.notice;

import com.example.opensource.entity.notice.Notice;
import lombok.Data;

@Data
public class NoticeDto {
    private String title;
    private String content;

    public NoticeDto (Notice notice){
        this.title = notice.getTitle();
        this.content = notice.getContent();
    }
}