package com.nicostone.studentmanager.courses.controller;

import com.nicostone.studentmanager.courses.model.Course;
import com.nicostone.studentmanager.courses.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return new ResponseEntity<Course>(
                courseService.addCourse(course), HttpStatus.OK
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        return new ResponseEntity<Course>(
                courseService.updateCourse(course), HttpStatus.OK
        );
    }

    @PutMapping("/join/course/{courseId}/student/{studentId}")
    public ResponseEntity<String> joinStudent(@PathVariable long courseId, @PathVariable long studentId){
        courseService.addToClass(courseId, studentId);
        return ResponseEntity.ok("Student has joined class");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}
