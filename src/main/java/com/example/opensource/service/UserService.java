package com.example.opensource.service;

import com.example.opensource.dto.user.UserInfoDto;
import com.example.opensource.dto.user.UserLoginDto;
import com.example.opensource.entity.lecture.Lecture;
import com.example.opensource.entity.lecture.UserConLec;
import com.example.opensource.entity.user.Users;
import com.example.opensource.repository.lecture.LectureRepository;
import com.example.opensource.repository.user.UserConLecRepository;
import com.example.opensource.repository.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public ResponseEntity postUser(UserLoginDto userLoginDto){
        Users users = new Users(userLoginDto);
        Lecture lecture = lectureRepository.findById(1l)
                .orElseThrow(() -> new IllegalStateException("강의 없음"));

        UserConLec userConLec = new UserConLec(users, lecture);

        userConLecRepository.save(userConLec);
        usersRepository.save(users);

        return new ResponseEntity("유저 등록 완료", HttpStatus.OK);
    }

    public UserLoginDto postLogin(UserLoginDto userLoginDto) {
        Users users = usersRepository.findByLoginId(userLoginDto.getId());
        UserLoginDto user;
        if(users.getLoginPass().equals(userLoginDto.getPass())){
            user = new UserLoginDto(users);
        } else {
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }

        return user;
    }

}
