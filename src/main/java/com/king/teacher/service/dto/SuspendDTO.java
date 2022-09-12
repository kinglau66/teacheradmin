package com.king.teacher.service.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * A DTO representing a user, with his authorities.
 */
public class SuspendDTO implements Serializable {

    /**
     * student email
     */
    @NotNull
    @Email
    private String student;

    public SuspendDTO() {}

    public @NotNull @Email String getStudent() {
        return this.student;
    }

    public void setStudent(@NotNull @Email String student) {
        this.student = student;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SuspendDTO)) return false;
        final SuspendDTO other = (SuspendDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$student = this.getStudent();
        final Object other$student = other.getStudent();
        if (this$student == null ? other$student != null : !this$student.equals(other$student)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SuspendDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $student = this.getStudent();
        result = result * PRIME + ($student == null ? 43 : $student.hashCode());
        return result;
    }

    public String toString() {
        return "SuspendDTO(student=" + this.getStudent() + ")";
    }
}
