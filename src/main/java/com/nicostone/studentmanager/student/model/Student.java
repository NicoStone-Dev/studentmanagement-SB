package com.nicostone.studentmanager.student.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long Id;
    private String name;
    private String email;
    private String dateOfBirth;
    private String grade_year;
    private String courses;
    @Column(name = "student_code", unique = true, nullable = false, updatable = false)
    private String student_code;

    public Student() {
    }

    public Student(long id, String name, String email, String dateOfBirth, String grade_year, String courses, String student_code) {
        Id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.grade_year = grade_year;
        this.courses = courses;
        this.student_code = student_code;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGrade_year() {
        return grade_year;
    }

    public String getCourses() {
        return courses;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGrade_year(String grade_year) {
        this.grade_year = grade_year;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", grade_year='" + grade_year + '\'' +
                ", courses='" + courses + '\'' +
                ", student_code=" + student_code +
                '}';
    }
}
