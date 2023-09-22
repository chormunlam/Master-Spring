package com.example.learnjpaandhibernate.course.springdatajpa;

import com.example.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpirngDataJpaRepo extends JpaRepository<Course, Long> {
}
