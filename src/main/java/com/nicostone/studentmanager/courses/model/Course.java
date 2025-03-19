package com.nicostone.studentmanager.courses.model;

import com.nicostone.studentmanager.student.model.Student;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_courses")
public class Course implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    long id;
    private String name;
    private int hoursToFinish;
    private String mainTeacherName;
    private String mainTeacherEmail;
    @Column(name = "course_code", unique = true, nullable = false, updatable = false)
    private String course_code;

    @OneToMany
    private List<Student> studentList;

    public Course(){

    }

    public Course(String name, int hoursToFinish, String mainTeacherEmail, String course_code) {
        this.name = name;
        this.hoursToFinish = hoursToFinish;
        this.mainTeacherEmail = mainTeacherEmail;
        this.course_code = course_code;
    }

    public String getMainTeacherName() {
        return mainTeacherName;
    }

    public void setMainTeacherName(String mainTeacherName) {
        this.mainTeacherName = mainTeacherName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHoursToFinish() {
        return hoursToFinish;
    }

    public String getMainTeacherEmail() {
        return mainTeacherEmail;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHoursToFinish(int hoursToFinish) {
        this.hoursToFinish = hoursToFinish;
    }

    public void setMainTeacherEmail(String mainTeacherEmail) {
        this.mainTeacherEmail = mainTeacherEmail;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hoursToFinish='" + hoursToFinish + '\'' +
                ", mainTeacherEmail='" + mainTeacherEmail + '\'' +
                ", course_code='" + course_code + '\'' +
                '}';
    }
}
