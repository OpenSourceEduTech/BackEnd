package com.example.opensource.repository.lecture;

import com.example.opensource.entity.lecture.Lecture;
import com.example.opensource.entity.lecture.SecretBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
