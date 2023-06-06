package com.example.opensource.controller;


import com.example.opensource.dto.homework.HomeWorkDto;
import com.example.opensource.dto.homework.MindMapDto;
import com.example.opensource.dto.lecture.LectureInfoDto;
import com.example.opensource.dto.lecture.SecretBoardListDto;
import com.example.opensource.dto.notice.NoticeDto;
import com.example.opensource.dto.user.UserInfoDto;
import com.example.opensource.service.LectureService;
import com.example.opensource.service.SecretBoardService;
import com.example.opensource.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {
    private final UserService userService;
    private final SecretBoardService secretBoardService;
    private final LectureService lectureService;

    /**
     * 수업
     */
    @GetMapping()
    public List<LectureInfoDto> getLectures() {
        return lectureService.getLectures();
    }

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
     * 과제 등록
     */
    @PostMapping("{lectureId}/homework")
    public ResponseEntity postHomework(@PathVariable(name = "lectureId") Long lectureId,
                                       @RequestPart("homeworkDto") HomeWorkDto homeWorkDto,
                                       @RequestPart("file") MultipartFile file) {

        return lectureService.postHomework(lectureId, homeWorkDto, file);
    }

    /**
     * 과제 상세
     */
    @GetMapping("homework/{homeworkId}")
    public HomeWorkDto getHomeworkDetail(@PathVariable(name = "homeworkId") Long homeworkId){
        return lectureService.getHomework(homeworkId);
    }

    /**
     * 공지 조회
     */
    @GetMapping("{lectureId}/notices")
    public List<NoticeDto> getNotices(@PathVariable(name = "lectureId") Long lectureId) {
        return lectureService.getNotices(lectureId);
    }

    /**
     * 공지 등록
     */
    @PostMapping("{lectureId}/notice")
    public ResponseEntity postHomework(@PathVariable(name = "lectureId") Long lectureId,
                                       @RequestBody NoticeDto noticeDto) {
        return lectureService.postNotice(lectureId, noticeDto);
    }

    /**
     * 과제 상세
     */
    @GetMapping("notices/{noticeId}")
    public NoticeDto getNoticeDetail(@PathVariable(name = "noticeId") Long noticeId){
        return lectureService.getNotice(noticeId);
    }

    /**
     * 마인드맵
     */
    @GetMapping("{lectureId}/mindmap")
    public MindMapDto getMindMap(@PathVariable(name = "lectureId") Long lectureId) {
        return lectureService.getMindMap(lectureId);
    }
}
