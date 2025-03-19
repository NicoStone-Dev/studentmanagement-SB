package com.nicostone.studentmanager.courses.service;

import com.nicostone.studentmanager.courses.model.Course;
import com.nicostone.studentmanager.courses.repository.CourseRepo;
import com.nicostone.studentmanager.courses.exceptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CourseService {
    private final CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    //List courses method
    public List<Course> getCourses(){
        return courseRepo.findAll();
    }

    //Add courses method
    public Course addCourse(Course course) {
        course.setCourse_code(UUID.randomUUID().toString());
        return courseRepo.save(course);
    }

    //TO-D0: an update method

    //Delete courses method
    public void deleteCourse(long ID) {
        if (courseRepo.existsById(ID)) {
            courseRepo.deleteById(ID);
        } else {
            throw new CourseNotFoundException("course with id: " + ID + " not found");
        }
        //We're gonna append the student list through here
    }
}
