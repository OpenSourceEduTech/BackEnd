package com.example.opensource.service;

import com.example.opensource.dto.lecture.SecretBoardListDto;
import com.example.opensource.entity.lecture.Lecture;
import com.example.opensource.entity.lecture.SecretBoard;
import com.example.opensource.repository.lecture.LectureRepository;
import com.example.opensource.repository.lecture.SecertBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SecretBoardService {
    private final SecertBoardRepository secertBoardRepository;
    private final LectureRepository lectureRepository;

    public List<SecretBoardListDto> getSecretBoardListDto(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalStateException("없는 강의"));
        List<SecretBoardListDto> secretBoardListDtos = new ArrayList<>();

        for(SecretBoard secretBoard : lecture.getSecertBoardList()) {
            SecretBoardListDto secretBoardListDto = new SecretBoardListDto(secretBoard);

            secretBoardListDtos.add(secretBoardListDto);
        }

        return secretBoardListDtos;
    }
}
