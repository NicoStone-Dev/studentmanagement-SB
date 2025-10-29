package com.nicostone.studentmanager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long Id;
    private String name;
    private String email;
    private String dateOfBirth;
    private String grade_year;
    @Column(name = "student_code", unique = true, nullable = false, updatable = false)
    private String student_code;

    /*
        Fetch type tells the database the kind of priority is offered for each class in the relation,
        if it's set to lazy, the class will be loaded on demand, if it's set to EAGER the it'll be loaded as soon as possible.
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="attributedCourse_id", nullable = true)
    @JsonBackReference
    //Following the issue i had with the serialization, this BREAKS such so it doesn't go into recursion error.
    private Course attributedCourse;

    public Student() {
    }

    //Constructors
    public Student(String name, String email, String dateOfBirth, String grade_year, String student_code) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.grade_year = grade_year;
        this.student_code = student_code;
    }
    // Getter and setter for the course the student is assigned
    public Course getAttributedCourse() {
        return attributedCourse;
    }

    public void setAttributedCourse(Course attributedCourse) {
        this.attributedCourse = attributedCourse;
    }


    //From here on down, we set the setters and getters for other variables
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

    public String getStudent_code() {
        return student_code;
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
                ", student_code='" + student_code + '\'' +
                ", Course=" + attributedCourse +
                '}';
    }
}
