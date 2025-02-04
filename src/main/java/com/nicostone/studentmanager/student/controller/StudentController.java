package com.nicostone.studentmanager.student.controller;

import com.nicostone.studentmanager.student.model.Student;
import com.nicostone.studentmanager.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/page")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/studentlist")
    public ResponseEntity<List<Student>> studentList(){
        List<Student> students = studentService.studentList();

        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> newStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);

        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }
}
