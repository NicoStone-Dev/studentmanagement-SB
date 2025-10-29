package com.nicostone.studentmanager.student.repository;

import com.nicostone.studentmanager.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    Optional<Student> findStudentById(long id);
}
