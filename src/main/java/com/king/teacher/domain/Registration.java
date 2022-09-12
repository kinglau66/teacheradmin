package com.king.teacher.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
}
