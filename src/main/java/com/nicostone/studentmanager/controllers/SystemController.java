package com.nicostone.studentmanager.controllers;

import com.nicostone.studentmanager.models.Course;
import com.nicostone.studentmanager.models.CourseDTO;
import com.nicostone.studentmanager.models.Student;
import com.nicostone.studentmanager.models.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SystemController {

    private final CourseController courseController;
    private final StudentController studentController;

    @Autowired
    public SystemController(CourseController courseController, StudentController studentController) {
        this.courseController = courseController;
        this.studentController = studentController;
    }

    // Course-related endpoints
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return courseController.courseList();
    }

    @GetMapping("/courses/search/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") long id) {
        return courseController.findCourseById(id);
    }

    @GetMapping("/courses/{id}/show/students")
    public ResponseEntity<List<Student>> getCourseStudents(@PathVariable("id") long courseId) {
        return courseController.showStudents(courseId);
    }

    @PostMapping("/courses/add")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return courseController.addCourse(course);
    }

    @PatchMapping("/courses/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody CourseDTO course) {
        return courseController.updateCourse(id, course);
    }

    @PutMapping("/courses/join/{courseId}/{studentId}")
    public ResponseEntity<Map<String, String>> enrollStudent(
            @PathVariable long courseId,
            @PathVariable long studentId) {
        return courseController.joinStudent(courseId, studentId);
    }

    @DeleteMapping("/courses/delete/{id}")
    public ResponseEntity<Map<String, String>> removeCourse(@PathVariable("id") long id) {
        return courseController.deleteCourse(id);
    }

    // Student-related endpoints
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return studentController.studentList();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        return studentController.findStudentById(id);
    }

    @PostMapping("/students/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return studentController.addStudent(student);
    }

    @PatchMapping("/students/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody StudentDTO student) {
        return studentController.updateStudent(id, student);
    }

    @DeleteMapping("/students/delete/{id}")
    public ResponseEntity<Void> removeStudent(@PathVariable("id") long id) {
        return studentController.deleteStudent(id);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboard() {
        List<Course> courses = courseController.courseList().getBody();
        List<Student> students = studentController.studentList().getBody();

        Map<String, Object> dashboard = Map.of(
                "totalCourses", courses != null ? courses.size() : 0,
                "totalStudents", students != null ? students.size() : 0,
                "recentCourses", courses != null ? courses.stream().limit(5).toList() : List.of(),
                "recentStudents", students != null ? students.stream().limit(5).toList() : List.of()
        );

        return new ResponseEntity<>(dashboard, HttpStatus.OK);
    }
}