package com.example.simplecourses.repository;

import com.example.simplecourses.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
