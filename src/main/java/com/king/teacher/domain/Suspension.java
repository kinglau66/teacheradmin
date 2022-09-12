package com.king.teacher.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "suspension")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@IdClass(RegistrationId.class)
public class Suspension {

    /**
     * suspended by
     */
    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = { "suspensions" }, allowSetters = true)
    private Teacher teacher;

    @Id
    @OneToOne
    @JsonIgnoreProperties(value = { "suspensions" }, allowSetters = true)
    private Student student;

    @Column(name = "suspendDate", length = 50)
    private LocalDateTime suspendDate = LocalDateTime.now();

    public Suspension() {}

    public Suspension(Teacher teacher, Student student, LocalDateTime suspendDate) {
        this.teacher = teacher;
        this.student = student;
        this.suspendDate = suspendDate;
    }

    public static SuspensionBuilder builder() {
        return new SuspensionBuilder();
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public Student getStudent() {
        return this.student;
    }

    public LocalDateTime getSuspendDate() {
        return this.suspendDate;
    }

    @JsonIgnoreProperties(value = { "registrations" }, allowSetters = true)
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @JsonIgnoreProperties(value = { "registrations" }, allowSetters = true)
    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSuspendDate(LocalDateTime suspendDate) {
        this.suspendDate = suspendDate;
    }

    public String toString() {
        return (
            "Suspension(teacher=" + this.getTeacher() + ", student=" + this.getStudent() + ", suspendDate=" + this.getSuspendDate() + ")"
        );
    }

    public static class SuspensionBuilder {

        private Teacher teacher;
        private Student student;
        private LocalDateTime suspendDate;

        SuspensionBuilder() {}

        public SuspensionBuilder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public SuspensionBuilder student(Student student) {
            this.student = student;
            return this;
        }

        public SuspensionBuilder suspendDate(LocalDateTime suspendDate) {
            this.suspendDate = suspendDate;
            return this;
        }

        public Suspension build() {
            return new Suspension(teacher, student, suspendDate);
        }

        public String toString() {
            return (
                "Suspension.SuspensionBuilder(teacher=" +
                this.teacher +
                ", student=" +
                this.student +
                ", suspendDate=" +
                this.suspendDate +
                ")"
            );
        }
    }
}
