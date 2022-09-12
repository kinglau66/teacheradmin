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
    @JsonIgnoreProperties(value = { "registrations" }, allowSetters = true)
    private Teacher teacher;

    @Id
    @OneToOne
    @JsonIgnoreProperties(value = { "registrations" }, allowSetters = true)
    private Student student;

    @Column(name = "suspendDate", length = 50)
    private LocalDateTime suspendDate = LocalDateTime.now();

    public Suspension() {}

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
}
