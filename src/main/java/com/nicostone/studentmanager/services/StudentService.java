package com.nicostone.studentmanager.student.service;

import com.nicostone.studentmanager.courses.service.CourseService;
import com.nicostone.studentmanager.student.DTOs.StudentDTO;
import com.nicostone.studentmanager.student.exception.UserNotFoundException;
import com.nicostone.studentmanager.student.model.Student;
import com.nicostone.studentmanager.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseService courseService;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }

    public Student addStudent(Student student) {
        student.setStudent_code(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }

    public List<Student> studentList() {

        return studentRepository.findAll();
    }

    public Student findStudent(long Id) {
        return studentRepository.findStudentById(Id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + Id + " not found"));
    }

    public Student updateStudent(long id, StudentDTO patchStudent) {
        Student student = findStudent(id);

        if (patchStudent.getName() != null) {
            student.setName(patchStudent.getName());
        }
        if (patchStudent.getEmail() != null) {
            student.setEmail(patchStudent.getEmail());
        }
        if (patchStudent.getDateOfBirth() != null) {
            student.setDateOfBirth(patchStudent.getDateOfBirth());
        }
        if (patchStudent.getGrade_year() != null) {
            student.setGrade_year(patchStudent.getGrade_year());
        }

        return studentRepository.save(student);
    }

    public void deleteStudent(long Id) {
        if (studentRepository.existsById(Id)) {
            studentRepository.deleteById(Id);
        } else {
            throw new UserNotFoundException("User with id: " + Id + " not found");
        }
    }
}
