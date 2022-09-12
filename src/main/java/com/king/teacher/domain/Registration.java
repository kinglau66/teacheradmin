package com.king.teacher.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "registration")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@IdClass(RegistrationId.class)
public class Registration {

    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = { "registrations" }, allowSetters = true)
    private Teacher teacher;

    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = { "registrations" }, allowSetters = true)
    private Student student;

    Registration(Teacher teacher, Student student) {
        this.teacher = teacher;
        this.student = student;
    }

    public static RegistrationBuilder builder() {
        return new RegistrationBuilder();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equals(teacher, that.teacher) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacher, student);
    }

    public static class RegistrationBuilder {

        private Teacher teacher;
        private Student student;

        RegistrationBuilder() {}

        public RegistrationBuilder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public RegistrationBuilder student(Student student) {
            this.student = student;
            return this;
        }

        public Registration build() {
            return new Registration(teacher, student);
        }

        public String toString() {
            return "Registration.RegistrationBuilder(teacher=" + this.teacher + ", student=" + this.student + ")";
        }
    }
}
