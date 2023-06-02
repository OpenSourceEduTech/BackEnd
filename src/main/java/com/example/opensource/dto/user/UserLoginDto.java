package com.example.opensource.dto.user;

import com.example.opensource.entity.user.Role;
import com.example.opensource.entity.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginDto {
    private String id;
    private String pass;
    private String role;

    public UserLoginDto(Users users) {
        this.id = users.getLoginId();
        this.pass = users.getLoginPass();
        if(users.getRole()== Role.STUDENT)
            this.role = "student";
        else
            this.role = "professor";
    }
}
