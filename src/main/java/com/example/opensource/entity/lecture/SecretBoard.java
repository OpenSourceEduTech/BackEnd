package com.example.opensource.entity.lecture;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SecretBoard {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;
}
