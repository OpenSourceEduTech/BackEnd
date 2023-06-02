package com.example.opensource.controller;


import com.example.opensource.dto.homework.HomeWorkDto;
import com.example.opensource.dto.lecture.SecretBoardListDto;
import com.example.opensource.dto.notice.NoticeDto;
import com.example.opensource.dto.user.UserInfoDto;
import com.example.opensource.service.LectureService;
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
    private final LectureService lectureService;

    /**
     * 사용자 정보 리스트 가져오기
     * @param lectureId
     * @return
     */
    @GetMapping("{lectureId}/users")
    public List<UserInfoDto> getUsersListenLec(@PathVariable(name = "lectureId") Long lectureId) {
        return userService.getUserListenLec(lectureId);
    }

    @GetMapping("{lectureId}/secrets")
    public List<SecretBoardListDto> getSecretBoardList(@PathVariable(name = "lectureId") Long lectureId) {
        return secretBoardService.getSecretBoardListDto(lectureId);
    }

    /**
     * 과제 조회
     */
    @GetMapping("{lectureId}/homeworks")
    public List<HomeWorkDto> getHomeworks(@PathVariable(name = "lectureId") Long lectureId) {
        return lectureService.getHomeworks(lectureId);
    }


    /**
     * 공지 조회
     */
    @GetMapping("{lectureId}/notices")
    public List<NoticeDto> getNotices(@PathVariable(name = "lectureId") Long lectureId) {
        return lectureService.getNotices(lectureId);
    }

}
