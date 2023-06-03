package com.example.opensource.dto.notice;

import com.example.opensource.entity.notice.Notice;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeDto {
    private Long id;
    private String title;
    private String content;

    public NoticeDto (Notice notice){
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
    }
}
