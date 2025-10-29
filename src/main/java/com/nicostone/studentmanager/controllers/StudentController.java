package com.nicostone.studentmanager.controllers;

import com.nicostone.studentmanager.models.Student;
import com.nicostone.studentmanager.services.StudentService;
import com.nicostone.studentmanager.models.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }   

    @GetMapping("/list")
    public ResponseEntity<List<Student>> studentList(){
        List<Student> students = studentService.studentList();

        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable("id") long Id){
        return new ResponseEntity<>(studentService.findStudent(Id), HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> newStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);

        return new ResponseEntity<Student>(addedStudent, HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody StudentDTO student){
        return new ResponseEntity<Student>(
                studentService.updateStudent(id, student), HttpStatus.OK
                );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") long Id){
        studentService.deleteStudent(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
