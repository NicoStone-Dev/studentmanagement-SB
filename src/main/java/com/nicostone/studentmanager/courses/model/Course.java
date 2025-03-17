package com.nicostone.studentmanager.courses.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "courses")
public class Course implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, updatable = false)
    long id;
    private String name;
    private String hoursToFinish;
    private String mainTeacherEmail;
    @Column(name = "course_code", unique = true, nullable = false, updatable = false)
    private String course_code;

    public Course(){

    }

    public Course(long id, String name, String hoursToFinish, String mainTeacherEmail, String course_code) {
        this.id = id;
        this.name = name;
        this.hoursToFinish = hoursToFinish;
        this.mainTeacherEmail = mainTeacherEmail;
        this.course_code = course_code;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHoursToFinish() {
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

    public void setHoursToFinish(String hoursToFinish) {
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
