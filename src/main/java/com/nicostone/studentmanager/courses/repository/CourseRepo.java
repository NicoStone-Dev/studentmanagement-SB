package com.nicostone.studentmanager.courses.repository;

import com.nicostone.studentmanager.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    Optional<Course> findCourseById(long id);
}
