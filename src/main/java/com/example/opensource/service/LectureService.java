package com.example.opensource.service;

import com.example.opensource.dto.homework.HomeWorkDto;
import com.example.opensource.dto.notice.NoticeDto;
import com.example.opensource.entity.homework.HomeWork;
import com.example.opensource.entity.lecture.Lecture;
import com.example.opensource.entity.notice.Notice;
import com.example.opensource.repository.homework.HomeworkRepository;
import com.example.opensource.repository.lecture.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
    private final HomeworkRepository homeworkRepository;

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
}
