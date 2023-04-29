package com.example.opensource.repository;

import com.example.opensource.entity.lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
