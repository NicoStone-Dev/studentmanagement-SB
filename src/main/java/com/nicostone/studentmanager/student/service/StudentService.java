package com.nicostone.studentmanager.student.service;

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

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        student.setStudent_code(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }

    public List<Student> studentList(){
        return studentRepository.findAll();
    }

    public Student findStudent(long Id){
        return studentRepository.findStudentById(Id)
                .orElseThrow(() ->new UserNotFoundException("User with id: " + Id + " not found"));
    }

    public void deleteStudent(long Id){
        if (studentRepository.existsById(Id)) {
            studentRepository.deleteById(Id);
        } else {
            throw new UserNotFoundException("User with id: " + Id + " not found");
        }


    }
}
