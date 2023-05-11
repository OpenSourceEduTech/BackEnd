package com.example.opensource.repository.lecture;

import com.example.opensource.entity.lecture.SecretBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecertBoardRepository extends JpaRepository<SecretBoard, Long> {
}
