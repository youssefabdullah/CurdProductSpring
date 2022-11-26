package com.example.ProjectCurd.repository;

import com.example.ProjectCurd.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
