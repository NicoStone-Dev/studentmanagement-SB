package com.nicostone.studentmanager.courses.service;

import com.nicostone.studentmanager.courses.DTOs.CourseDTO;
import com.nicostone.studentmanager.courses.model.Course;
import com.nicostone.studentmanager.courses.repository.CourseRepo;
import com.nicostone.studentmanager.courses.exceptions.CourseNotFoundException;
import com.nicostone.studentmanager.student.exception.UserNotFoundException;
import com.nicostone.studentmanager.student.model.Student;
import com.nicostone.studentmanager.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CourseService {
    private final CourseRepo courseRepo;
    private final StudentRepository studentRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo, StudentRepository studentRepo) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    //List courses method
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    //Add courses method
    public Course addCourse(Course course) {
        course.setCourse_code(UUID.randomUUID().toString());
        return courseRepo.save(course);
    }

    //Update method
    public Course updateCourse(long id, CourseDTO patchCourse) {
        Course course = findCourse(id);

        if (patchCourse.getName() != null) {
            course.setName(patchCourse.getName());
        }
        if (patchCourse.getMainTeacherEmail() != null) {
            course.setMainTeacherEmail(patchCourse.getMainTeacherEmail());
        }
        if (patchCourse.getMainTeacherName() != null) {
            course.setMainTeacherName(patchCourse.getMainTeacherName());
        }
        if(patchCourse.getHoursToFinish() != null){
            course.setHoursToFinish(patchCourse.getHoursToFinish());
        }

        return courseRepo.save(course);
    }

    //Delete courses method
    public void deleteCourse(long ID) {
        if (courseRepo.existsById(ID)) {
            courseRepo.deleteById(ID);
        } else {
            throw new CourseNotFoundException("course with id: " + ID + " not found");
        }
    }

    public Course findCourse(long id){
        return courseRepo.findCourseById(id)
                .orElseThrow(() ->new CourseNotFoundException("Course with id: " + id + " not found"));
    }

    public List<Student> showClassStud(long id){
        Course current = this.findCourse(id);
        return current.getStudentList();
    }

    //We're going to append the student list through here
    public void addToClass(long courseId, long studentId){
            Student addedStudent = studentRepo.findStudentById(studentId)
                    .orElseThrow(() -> new UserNotFoundException("Student with id: " + studentId + "not found")) ;
            Course course = this.findCourse(courseId);

            System.out.println(addedStudent.toString());
            System.out.println(course.toString());

            course.getStudentList().add(addedStudent);
            courseRepo.save(course);

            addedStudent.setAttributedCourse(course);
            studentRepo.save(addedStudent);
    }
}
