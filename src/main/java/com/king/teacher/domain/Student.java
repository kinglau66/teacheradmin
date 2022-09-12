package com.king.teacher.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "student")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "teacher")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "student, teacher" }, allowSetters = true)
    private Set<Registration> registrations = new HashSet<>();

    public Student() {}

    public Long getId() {
        return this.id;
    }

    public @Email @Size(min = 5, max = 254) String getEmail() {
        return this.email;
    }

    public @Size(max = 50) String getName() {
        return this.name;
    }

    public Set<Registration> getRegistrations() {
        return this.registrations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(@Email @Size(min = 5, max = 254) String email) {
        this.email = email;
    }

    public void setName(@Size(max = 50) String name) {
        this.name = name;
    }

    @JsonIgnoreProperties(value = { "student, teacher" }, allowSetters = true)
    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }

    public String toString() {
        return "Student(id=" + this.getId() + ", email=" + this.getEmail() + ", name=" + this.getName() + ")";
    }
}
