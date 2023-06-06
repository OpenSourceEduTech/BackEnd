package com.example.opensource.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.example.opensource.dto.homework.HomeWorkDto;
import com.example.opensource.dto.homework.MindMapDto;
import com.example.opensource.dto.lecture.LectureInfoDto;
import com.example.opensource.dto.notice.NoticeDto;
import com.example.opensource.entity.homework.HomeWork;
import com.example.opensource.entity.lecture.Lecture;
import com.example.opensource.entity.notice.Notice;
import com.example.opensource.repository.homework.HomeworkRepository;
import com.example.opensource.repository.lecture.LectureRepository;
import com.example.opensource.repository.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
    private final HomeworkRepository homeworkRepository;
    private final NoticeRepository noticeRepository;

    /**
     * 수업
     */
    public List<LectureInfoDto> getLectures() {
        List<Lecture> lectures = lectureRepository.findAll();
        List<LectureInfoDto> lectureInfoDtos = new ArrayList<>();
        for(Lecture l : lectures) {
            LectureInfoDto lectureInfoDto = new LectureInfoDto(l);
            lectureInfoDtos.add(lectureInfoDto);
        }

        return lectureInfoDtos;
    }

    /**
     * 과제
     */

    public List<HomeWorkDto> getHomeworks(Long id) {
        List<HomeWorkDto> homeWorkDtos = new ArrayList<>();
        Lecture lec = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("없는 강의"));
        for(HomeWork h : lec.getHomeWorkList()) {
            HomeWorkDto homeWorkDto = new HomeWorkDto(h);

            homeWorkDtos.add(homeWorkDto);
        }

        return homeWorkDtos;
    }

    public ResponseEntity postHomework(Long lectureId, HomeWorkDto homeWorkDto, MultipartFile file) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalStateException("없는 강의"));

        HomeWork homeWork = new HomeWork(homeWorkDto, lecture);
        if (!file.isEmpty()) {
            try {
                // 현재 날짜와 시간 가져오기
                LocalDateTime now = LocalDateTime.now();

                // 날짜와 시간 형식 지정
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

                // 형식에 맞게 날짜와 시간을 문자열로 변환
                String formattedDateTime = now.format(formatter);

                String fileName = file.getOriginalFilename();
                // 업로드된 파일을 로컬 경로에 저장
                String filePath = "/Users/seongwon-ha/Desktop/file/" + formattedDateTime + fileName; // 저장할 경로와 파일명 설정
                File dest = new File(filePath);
                file.transferTo(dest);

                // 파일 경로를 데이터베이스에 저장하거나 응답으로 반환
                // ...
                homeWork.addFilePath(filePath, fileName);

            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity("파일 업로드 실패", HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity("업로드할 파일이 없습니다", HttpStatus.BAD_REQUEST);
        }
        lecture.getHomeWorkList().add(homeWork);
        homeworkRepository.save(homeWork);

        return new ResponseEntity("게시물 등록 완료", HttpStatus.OK);
    }

    public HomeWorkDto getHomework(Long homeworkId) {
        HomeWork hw = homeworkRepository.findById(homeworkId)
                .orElseThrow(()->new IllegalStateException("없는 강의"));

        HomeWorkDto hwd = new HomeWorkDto(hw);

        return hwd;
    }

    /**
     * 공지
     */

    public List<NoticeDto> getNotices(Long id) {
        List<NoticeDto> noticeDtos = new ArrayList<>();
        Lecture lec = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("없는 강의"));
        for(Notice n : lec.getNoticeList()) {
            NoticeDto noticeDto = new NoticeDto(n);

            noticeDtos.add(noticeDto);
        }

        return noticeDtos;
    }

    public ResponseEntity postNotice(Long lectureId, NoticeDto noticeDto) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalStateException("없는 강의"));

        Notice notice = new Notice(noticeDto, lecture);
        lecture.getNoticeList().add(notice);
        noticeRepository.save(notice);

        return new ResponseEntity("게시물 등록 완료", HttpStatus.OK);
    }

    public NoticeDto getNotice(Long noticeId) {
        Notice n = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalStateException("없는 공지"));
        NoticeDto nd = new NoticeDto(n);

        return nd;
    }

    /**
     * 마인드맵
     */

    public MindMapDto getMindMap(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalStateException("없는 강의"));

        MindMapDto mindMapDto = new MindMapDto(lecture);

        return mindMapDto;
    }

}
