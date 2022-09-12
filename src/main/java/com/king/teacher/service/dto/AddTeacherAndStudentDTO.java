package com.king.teacher.service.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * A DTO representing a user, with his authorities.
 */

public class AddTeacherAndStudentDTO implements Serializable {

    /**
     * teacher email
     */
    @NotNull
    private String email;

    /**
     * student name
     */
    @NotNull
    private String name;

    public AddTeacherAndStudentDTO() {}

    public @NotNull String getEmail() {
        return this.email;
    }

    public @NotNull String getName() {
        return this.name;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String toString() {
        return "AddTeacherDTO(email=" + this.getEmail() + ", name=" + this.getName() + ")";
    }
}
