package com.example.opensource.entity.lecture;

import com.example.opensource.entity.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class UserConLec {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int grade;


    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;

    public UserConLec(Users users, Lecture lecture) {
        this.users = users;
        this.lecture = lecture;
        this.grade = 0;
    }
}
