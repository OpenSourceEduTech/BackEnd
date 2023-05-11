package com.example.opensource.entity.user;


import com.example.opensource.entity.lecture.UserConLec;
import com.example.opensource.entity.user.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dept;
    private String profile;
    //학번
    private String deptId;

//    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "users")
    private List<UserConLec> userConLecList = new ArrayList<>();
}
