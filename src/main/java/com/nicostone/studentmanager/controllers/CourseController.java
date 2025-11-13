package com.nicostone.studentmanager.controllers;

import com.nicostone.studentmanager.models.CourseDTO;
import com.nicostone.studentmanager.models.Course;
import com.nicostone.studentmanager.services.CourseService;
import com.nicostone.studentmanager.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CourseController{
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    public ResponseEntity<List<Course>> courseList(){
        return new ResponseEntity<List<Course>>(
                courseService.getCourses(), HttpStatus.OK
        );
    }

    public ResponseEntity<Course> findCourseById(@PathVariable("id") long id){
        return new ResponseEntity<Course>(courseService.findCourse(id), HttpStatus.FOUND);
    }

    public ResponseEntity<List<Student>> showStudents(@PathVariable("id") long courseId){
        return new ResponseEntity<>(courseService.showClassStud(courseId), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return new ResponseEntity<Course>(
                courseService.addCourse(course), HttpStatus.OK
        );  
    }

    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody CourseDTO course){
        return new ResponseEntity<Course>(
                courseService.updateCourse(id, course), HttpStatus.OK
        );
    }

    public ResponseEntity<Map<String, String>> joinStudent(@PathVariable long courseId, @PathVariable long studentId) {
        courseService.addToClass(courseId, studentId);
        return ResponseEntity.ok(Map.of("message", "Student has joined class"));
    }

    public ResponseEntity<Map<String, String>> deleteCourse(@PathVariable("id") long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok(Map.of("message","Course Has Been Deleted! "));
    }
}
