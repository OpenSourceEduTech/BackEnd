package com.example.opensource.controller;


import com.example.opensource.dto.user.UserInfoDto;
import com.example.opensource.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {
    private final UserService userService;

    @GetMapping("{lectureId}/users")
    public List<UserInfoDto> getUsersListenLec(@PathVariable(name = "lectureId") Long lectureId) {
        return userService.getUserListenLec(lectureId);
    }
}
