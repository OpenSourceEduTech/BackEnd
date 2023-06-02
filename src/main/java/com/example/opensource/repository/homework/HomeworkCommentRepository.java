package com.example.opensource.repository.homework;

import com.example.opensource.entity.homework.HomeWorkComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkCommentRepository extends JpaRepository<HomeWorkComment, Long> {
}
