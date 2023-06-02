package com.example.opensource.controller;

import com.example.opensource.dto.user.UserLoginDto;
import com.example.opensource.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity postUser(@RequestBody UserLoginDto userLoginDto) {
        return userService.postUser(userLoginDto);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserLoginDto userLoginDto) {
        return userService.postLogin(userLoginDto);
    }
}
