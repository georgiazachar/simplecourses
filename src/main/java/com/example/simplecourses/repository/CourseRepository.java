package com.example.simplecourses.repository;

import com.example.simplecourses.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
