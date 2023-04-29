package com.example.opensource.repository;

import com.example.opensource.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
