package com.example.opensource.entity.lecture;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String image;

    @OneToMany(mappedBy = "lecture")
    private List<UserConLec> lectureList = new ArrayList<>();

}
