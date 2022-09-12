package com.king.teacher.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Registration {

    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = { "registrations" }, allowSetters = true)
    private Teacher teacher;

    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = { "registrations" }, allowSetters = true)
    private Student student;
}
