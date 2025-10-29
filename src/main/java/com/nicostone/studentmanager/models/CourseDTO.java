package com.nicostone.studentmanager.models;

import jakarta.annotation.Nullable;

public class CourseDTO {
    @Nullable
    private String name;
    @Nullable
    private Integer hoursToFinish;
    @Nullable
    private String mainTeacherName;
    @Nullable
    private String mainTeacherEmail;

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public Integer getHoursToFinish() {
        return hoursToFinish;
    }

    public void setHoursToFinish(@Nullable Integer hoursToFinish) {
        this.hoursToFinish = hoursToFinish;
    }

    @Nullable
    public String getMainTeacherName() {
        return mainTeacherName;
    }

    public void setMainTeacherName(@Nullable String mainTeacherName) {
        this.mainTeacherName = mainTeacherName;
    }

    @Nullable
    public String getMainTeacherEmail() {
        return mainTeacherEmail;
    }

    public void setMainTeacherEmail(@Nullable String mainTeacherEmail) {
        this.mainTeacherEmail = mainTeacherEmail;
    }

    @Override
    public String toString() {
        return "updateCourseDTO{" +
                "name='" + name + '\'' +
                ", hoursToFinish=" + hoursToFinish +
                ", mainTeacherName='" + mainTeacherName + '\'' +
                ", mainTeacherEmail='" + mainTeacherEmail + '\'' +
                '}';
    }
}
