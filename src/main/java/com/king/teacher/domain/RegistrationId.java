package com.king.teacher.domain;

import java.io.Serializable;

public class RegistrationId implements Serializable {

    private Teacher teacher;
    private Student student;

    public RegistrationId() {}

    public Teacher getTeacher() {
        return this.teacher;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String toString() {
        return "RegistrationId(teacher=" + this.getTeacher() + ", student=" + this.getStudent() + ")";
    }
}
