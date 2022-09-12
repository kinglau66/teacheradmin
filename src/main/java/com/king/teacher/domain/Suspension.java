package com.king.teacher.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "suspension")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@IdClass(RegistrationId.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
}
