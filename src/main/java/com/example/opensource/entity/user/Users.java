package com.example.opensource.entity.user;


import com.example.opensource.dto.user.UserLoginDto;
import com.example.opensource.entity.lecture.UserConLec;
import com.example.opensource.entity.user.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dept;
    private String profile;
    //학번
    private String deptId;
    private String loginId;
    private String loginPass;

//    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "users")
    private List<UserConLec> userConLecList = new ArrayList<>();


    public Users(UserLoginDto userLoginDto) {
        this.loginId = userLoginDto.getId();
        this.loginPass = userLoginDto.getPass();
        if(userLoginDto.getRole().equals("student"))
            this.role = Role.STUDENT;
        else
            this.role = Role.PROFESSOR;
        this.profile = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA2MDdfNyAg%2FMDAxNjU0NTY1NjQ5NzU5.9z_u_FB-IPFLFKsHxnCFtcbZ8Cwa5D9b42ddQO5RNJ8g.SzUdU3OjRqZRhUAOk1cnO6XTJgvAiXgHNux86FHUlTog.PNG.jasonhcho%2F1.png&type=a340";
        this.name = userLoginDto.getId();
    }
}
