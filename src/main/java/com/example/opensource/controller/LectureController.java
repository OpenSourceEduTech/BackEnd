package com.example.opensource.controller;


import com.example.opensource.dto.lecture.SecretBoardListDto;
import com.example.opensource.dto.user.UserInfoDto;
import com.example.opensource.service.SecretBoardService;
import com.example.opensource.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {
    private final UserService userService;
    private final SecretBoardService secretBoardService;

    /**
     * 사용자 정보 리스트 가져오기
     * @param lectureId
     * @return
     */
    @GetMapping("{lectureId}/users")
    public List<UserInfoDto> getUsersListenLec(@PathVariable(name = "lectureId") Long lectureId) {
        return userService.getUserListenLec(lectureId);
    }

    @GetMapping("{lectureId}/secret")
    public List<SecretBoardListDto> getSecretBoardList(@PathVariable(name = "lectureId") Long lectureId) {
        return secretBoardService.getSecretBoardListDto(lectureId);
    }


}
