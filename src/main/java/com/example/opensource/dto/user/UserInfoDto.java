package com.example.opensource.dto.user;

import com.example.opensource.entity.lecture.Lecture;
import com.example.opensource.entity.lecture.UserConLec;
import com.example.opensource.entity.user.Role;
import lombok.Data;

@Data
public class UserInfoDto {

    private String name;
    private String role;
    private String image;


    /**
     * 강의를 수강중인 유저 정보
     */
    public UserInfoDto(UserConLec userConLec){
        this.name = userConLec.getUsers().getName();
        this.image = userConLec.getUsers().getProfile();
        if(userConLec.getUsers().getRole() == Role.STUDENT)
            this.role = "student";
        else
            this.role = "professor";
    }
}
