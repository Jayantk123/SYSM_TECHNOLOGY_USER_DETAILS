package com.example.jayant.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


  static Optional<User> findStudentByEmail(String email) {
    return null;
  }


}
