package com.example.opensource.service;

import com.example.opensource.dto.lecture.LectureInfoDto;
import com.example.opensource.dto.user.UserInfoDto;
import com.example.opensource.entity.lecture.Lecture;
import com.example.opensource.entity.lecture.UserConLec;
import com.example.opensource.entity.user.Users;
import com.example.opensource.repository.LectureRepository;
import com.example.opensource.repository.UserConLecRepository;
import com.example.opensource.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final LectureRepository lectureRepository;
    private final UserConLecRepository userConLecRepository;

    //해당 수업을 듣는 사용자 정보 가져오기
    public List<UserInfoDto> getUserListenLec(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalStateException("없는 강의"));
        List<UserInfoDto> userInfoDtoList = new ArrayList<>();
        List<UserConLec> userConLecList = userConLecRepository.findAllByLecture(lecture)
                .orElseThrow(() -> new IllegalStateException("수강 중인 사람이 없음"));

        for(UserConLec userConLec : userConLecList) {
            UserInfoDto userInfoDto = new UserInfoDto(userConLec);

            userInfoDtoList.add(userInfoDto);
        }

        return userInfoDtoList;
    }

}
