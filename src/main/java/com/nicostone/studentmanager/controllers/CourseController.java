package com.nicostone.studentmanager.courses.controller;

import com.nicostone.studentmanager.courses.DTOs.CourseDTO;
import com.nicostone.studentmanager.courses.exceptions.CourseNotFoundException;
import com.nicostone.studentmanager.courses.model.Course;
import com.nicostone.studentmanager.courses.service.CourseService;
import com.nicostone.studentmanager.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController{
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Course>> courseList(){
        return new ResponseEntity<List<Course>>(
                courseService.getCourses(), HttpStatus.OK
        );
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable("id") long id){
        return new ResponseEntity<Course>(courseService.findCourse(id), HttpStatus.FOUND);
    }

    @GetMapping("/{id}/show/students")
    public ResponseEntity<List<Student>> showStudents(@PathVariable("id") long courseId){
        return new ResponseEntity<>(courseService.showClassStud(courseId), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return new ResponseEntity<Course>(
                courseService.addCourse(course), HttpStatus.OK
        );  
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody CourseDTO course){
        return new ResponseEntity<Course>(
                courseService.updateCourse(id, course), HttpStatus.OK
        );
    }

    @PutMapping("/join/course/{courseId}/student/{studentId}")
    public ResponseEntity<Map<String, String>> joinStudent(@PathVariable long courseId, @PathVariable long studentId){
        courseService.addToClass(courseId, studentId);
        return ResponseEntity.ok(Map.of("message","Student has joined class"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") long id){
<<<<<<< HEAD:src/main/java/com/nicostone/studentmanager/courses/controller/CourseController.java
        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CourseNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if course not found
        }
=======
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
>>>>>>> 25b5790 (Refactored the folder structure):src/main/java/com/nicostone/studentmanager/controllers/CourseController.java
    }
}
