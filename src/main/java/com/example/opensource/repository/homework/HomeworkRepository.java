package com.example.opensource.repository.homework;

import com.example.opensource.entity.homework.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HomeworkRepository extends JpaRepository<HomeWork, Long> {
}
