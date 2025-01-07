package com.example.springboot.repository;

import com.example.springboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByNameContainingIgnoreCase(String name);
}
