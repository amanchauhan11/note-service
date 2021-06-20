package com.notes.noteservice.repository;

import com.notes.noteservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  User findByEmail(String email);
}
