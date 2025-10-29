package com.nicostone.studentmanager.student.DTOs;

import jakarta.annotation.Nullable;

public class StudentDTO {
    @Nullable
    private String name;
    @Nullable
    private String email;
    @Nullable
    private String dateOfBirth;
    @Nullable
    private String grade_year;

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@Nullable String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Nullable
    public String getGrade_year() {
        return grade_year;
    }

    public void setGrade_year(@Nullable String grade_year) {
        this.grade_year = grade_year;
    }

    @Override
    public String toString() {
        return "updateStudentDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", grade_year='" + grade_year + '\'' +
                '}';
    }
}
