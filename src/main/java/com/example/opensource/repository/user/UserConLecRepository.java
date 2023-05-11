package com.example.opensource.repository.user;

import com.example.opensource.entity.lecture.Lecture;
import com.example.opensource.entity.lecture.UserConLec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserConLecRepository extends JpaRepository<UserConLec, Long> {
    Optional<List<UserConLec>> findAllByLecture(Lecture lecture);

}
