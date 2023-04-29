package com.example.opensource.repository;

import com.example.opensource.entity.lecture.Lecture;
import com.example.opensource.entity.lecture.UserConLec;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserConLecRepository extends JpaRepository<UserConLec, Long> {
    Optional<List<UserConLec>> findAllByLecture(Lecture lecture);
}
