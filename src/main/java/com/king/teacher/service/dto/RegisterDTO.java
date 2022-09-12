package com.king.teacher.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * A DTO representing a user, with his authorities.
 */
public class RegisterDTO implements Serializable {

    /**
     * teacher email
     */
    @NotNull
    @Email
    private String teacher;

    /**
     * student name
     */
    @NotEmpty
    private Set<@Email String> students = new HashSet<>();

    public RegisterDTO() {}

    public @NotNull @Email String getTeacher() {
        return this.teacher;
    }

    public @NotEmpty Set<@Email String> getStudents() {
        return this.students;
    }

    public void setTeacher(@NotNull @Email String teacher) {
        this.teacher = teacher;
    }

    public void setStudents(@NotEmpty Set<@Email String> students) {
        this.students = students;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RegisterDTO)) return false;
        final RegisterDTO other = (RegisterDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$teacher = this.getTeacher();
        final Object other$teacher = other.getTeacher();
        if (this$teacher == null ? other$teacher != null : !this$teacher.equals(other$teacher)) return false;
        final Object this$students = this.getStudents();
        final Object other$students = other.getStudents();
        if (this$students == null ? other$students != null : !this$students.equals(other$students)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RegisterDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $teacher = this.getTeacher();
        result = result * PRIME + ($teacher == null ? 43 : $teacher.hashCode());
        final Object $students = this.getStudents();
        result = result * PRIME + ($students == null ? 43 : $students.hashCode());
        return result;
    }

    public String toString() {
        return "RegisterDTO(teacher=" + this.getTeacher() + ", students=" + this.getStudents() + ")";
    }
}
