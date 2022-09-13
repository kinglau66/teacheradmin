package com.king.teacher.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
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

    @Size(max = 1)
    @Column(name = "suspend_ind", length = 1)
    private String suspendInd = "N";

    @Column(name = "suspend_date", length = 1)
    private LocalDateTime suspendDate;

    @OneToMany(mappedBy = "teacher")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "student, teacher" }, allowSetters = true)
    private Set<Registration> registrations = new HashSet<>();

    public Student() {}

    public Student(Long id, @Email @Size(min = 5, max = 254) String email, @Size(max = 50) String name, Set<Registration> registrations) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.registrations = registrations;
    }

    public Student(
        Long id,
        @Email @Size(min = 5, max = 254) String email,
        @Size(max = 50) String name,
        @Size(max = 1) String suspendInd,
        @Size(max = 1) LocalDateTime suspendDate,
        Set<Registration> registrations
    ) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.suspendInd = suspendInd;
        this.suspendDate = suspendDate;
        this.registrations = registrations;
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

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

    public String getSuspendInd() {
        return suspendInd;
    }

    public void setSuspendInd(String suspendInd) {
        this.suspendInd = suspendInd;
        if(suspendInd.equals("Y")) this.suspendDate = LocalDateTime.now();
    }

    public LocalDateTime getSuspendDate() {
        return suspendDate;
    }

    public void setSuspendDate(LocalDateTime suspendDate) {
        this.suspendDate = suspendDate;
    }

    @JsonIgnoreProperties(value = { "student, teacher" }, allowSetters = true)
    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }

    public String toString() {
        return "Student(id=" + this.getId() + ", email=" + this.getEmail() + ", name=" + this.getName() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$suspendInd = this.getSuspendInd();
        final Object other$suspendInd = other.getSuspendInd();
        if (this$suspendInd == null ? other$suspendInd != null : !this$suspendInd.equals(other$suspendInd)) return false;
        final Object this$suspendDate = this.getSuspendDate();
        final Object other$suspendDate = other.getSuspendDate();
        if (this$suspendDate == null ? other$suspendDate != null : !this$suspendDate.equals(other$suspendDate)) return false;
        final Object this$registrations = this.getRegistrations();
        final Object other$registrations = other.getRegistrations();
        if (this$registrations == null ? other$registrations != null : !this$registrations.equals(other$registrations)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Student;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $suspendInd = this.getSuspendInd();
        result = result * PRIME + ($suspendInd == null ? 43 : $suspendInd.hashCode());
        final Object $suspendDate = this.getSuspendDate();
        result = result * PRIME + ($suspendDate == null ? 43 : $suspendDate.hashCode());
        final Object $registrations = this.getRegistrations();
        result = result * PRIME + ($registrations == null ? 43 : $registrations.hashCode());
        return result;
    }

    public static class StudentBuilder {

        private Long id;

        @Email
        @Size(min = 5, max = 254)
        private String email;

        @Size(max = 50)
        private String name;

        private LocalDateTime suspendDate;

        private String suspendInd = "N";

        private Set<Registration> registrations;

        StudentBuilder() {}

        public StudentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder email(@Email @Size(min = 5, max = 254) String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder name(@Size(max = 50) String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder suspendInd(@Size(max = 1) String suspendInd) {
            this.suspendInd = suspendInd;
            if(suspendInd.equals("Y")) this.suspendDate = LocalDateTime.now();
            return this;
        }

        public StudentBuilder suspendDate(LocalDateTime suspendDate) {
            this.suspendDate = suspendDate;

            return this;
        }

        public StudentBuilder registrations(Set<Registration> registrations) {
            this.registrations = registrations;
            return this;
        }

        public Student build() {
            return new Student(id, email, name, registrations);
        }

        public String toString() {
            return (
                "Student.StudentBuilder(id=" +
                this.id +
                ", email=" +
                this.email +
                ", name=" +
                this.name +
                ", registrations=" +
                this.registrations +
                ")"
            );
        }
    }
}
