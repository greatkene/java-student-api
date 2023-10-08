package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Students> findStudentByEmail(String email);
}
